package com.itia.sitevitrine.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.itia.sitevitrine.beans.User;
import com.itia.sitevitrine.exceptions.GeneralException;
import com.itia.sitevitrine.models.Role;
import com.itia.sitevitrine.repository.UserRepository;
import com.itia.sitevitrine.services.UserService;
import com.itia.sitevitrine.utils.Constants;
import com.itia.sitevitrine.utils.ObjectMapper;
import com.itia.sitevitrine.utils.UserMapper;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository usersRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	private JavaMailSender mailSender;

	@Override
	public User create(User usr) throws GeneralException {
		if (this.usersRepository.existsByEmail(usr.getEmail())) {
			throw new GeneralException(Constants.EMAIL_ALREADY_USED_CODE, Constants.EMAIL_ALREADY_USED);
		}
		usr.setStatus(Constants.STATE_ACTIVATED);
		usr.setPassword(passwordEncoder.encode(usr.getPassword()));
		usr.setCreatedOn(new Date());
		return usersRepository.save(usr);
	}

	@Override
	public User update(User usr) throws GeneralException {
		Optional<User> userFound = usersRepository.findById(usr.getId());
		if (userFound.isPresent() && userFound.get().getStatus() == Constants.STATE_ACTIVATED) {
			usr.setLastUpdateOn(new Date());
		} else if (!userFound.isPresent()) {
			throw new GeneralException(Constants.USER_NOT_FOUND_CODE, Constants.USER_NOT_FOUND);
		} else if (userFound.isPresent() && userFound.get().getStatus() == Constants.STATE_DELETED) {
			throw new GeneralException(Constants.USER_ALREADY_DELETED_CODE, Constants.USER_ALREADY_DELETED);
		} else if (userFound.isPresent() && userFound.get().getStatus() == Constants.STATE_DEACTIVATED) {
			throw new GeneralException(Constants.USER_ALREADY_DEACTIVATED_CODE, Constants.USER_ALREADY_DEACTIVATED);
		}
		return usersRepository.save(usr);
	}

	@Override
	public List<User> getAllUser() {
		List<User> users = new ArrayList<User>();
		usersRepository.findAll().forEach(users::add);
		return users;
	}

	@Override
	public User deleteUser(Long userId) throws GeneralException {
		Optional<User> userFound = usersRepository.findById(userId);
		if (userFound.isPresent() && (userFound.get().getStatus() == Constants.STATE_ACTIVATED
				|| userFound.get().getStatus() == Constants.STATE_DEACTIVATED)) {
			userFound.get().setStatus(Constants.STATE_DELETED);
			userFound.get().setLastUpdateOn(new Date());
		} else if (!userFound.isPresent()) {
			throw new GeneralException(Constants.USER_NOT_FOUND_CODE, Constants.USER_NOT_FOUND);
		} else if (userFound.isPresent() && userFound.get().getStatus() == Constants.STATE_DELETED) {
			throw new GeneralException(Constants.USER_ALREADY_DELETED_CODE, Constants.USER_ALREADY_DELETED);
		}
		return usersRepository.save(userFound.get());
	}

	@Override
	public User findByEmail(String userMail) {
		return usersRepository.findByEmail(userMail).orElse(null);
	}

	@Override
	public User findUserById(Long userId) throws GeneralException {
		Optional<User> userFound = usersRepository.findById(userId);
		if (!userFound.isPresent()) {
			throw new GeneralException(Constants.USER_NOT_FOUND_CODE, Constants.USER_NOT_FOUND);
		}
		return usersRepository.findById(userId).get();
	}

	@Override
	public User updateUserPassword(Long userId, String olpPassword, String newPassword) throws GeneralException {
		Optional<User> userFound = usersRepository.findById(userId);
		if (userFound.isPresent() && userFound.get().getStatus() == Constants.STATE_ACTIVATED) {
			if (passwordEncoder.matches(olpPassword, userFound.get().getPassword())) {
				userFound.get().setPassword(passwordEncoder.encode(newPassword));
				userFound.get().setLastUpdateOn(new Date());
			} else {
				throw new GeneralException(Constants.OLD_PASSWORD_NOT_MATCH_CODE, Constants.OLD_PASSWORD_NOT_MATCH);
			}
		} else if (userFound.isPresent() && userFound.get().getStatus() == Constants.STATE_DELETED) {
			throw new GeneralException(Constants.USER_ALREADY_DELETED_CODE, Constants.USER_ALREADY_DELETED);
		} else if (userFound.isPresent() && userFound.get().getStatus() == Constants.STATE_DEACTIVATED) {
			throw new GeneralException(Constants.USER_ALREADY_DEACTIVATED_CODE, Constants.USER_ALREADY_DEACTIVATED);
		}
		return usersRepository.save(userFound.get());
	}

	@Override
	public User findById(Long id) {
		return this.usersRepository.findById(id).get();
	}

	@Override
	public void sendMailToResetPassword(String sender, String toEmail, String body, String subject) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(sender);
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject(subject);

		try {
			mailSender.send(message);
		} catch (MailException e) {
			throw new MailException("Simple mail not send to customer") {
			};
		}
	}

	@Override
	public Boolean updateUserStatus(User user) {
		Boolean response = false;
		Optional<User> userFound = usersRepository.findById(user.getId());
		if (user.getId() != null) {
			if (userFound.isPresent()) {
				usersRepository.updateUserStatus(user.getId(), user.getStatus());
				response = true;
			} else {
				String errorMessage = "L'utilisateur " + user.getUsername() + ":" + user.getId() + " n'existe pas";
				throw new NoSuchElementException(errorMessage);
			}
		}
		return response;
	}

	@Override
	public boolean existsById(Long userId) throws GeneralException {
		return this.usersRepository.existsById(userId);
	}

	@Override
	public List<Role> getUserRolesList(Long userId) throws GeneralException {
		User user = this.findById(userId);
		return user.getRoles();
	}
}
