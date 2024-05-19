package com.itia.sitevitrine.services;

import java.util.List;

import com.itia.sitevitrine.beans.User;
import com.itia.sitevitrine.exceptions.GeneralException;
import com.itia.sitevitrine.models.Role;

public interface UserService {
	public User create(User usr) throws GeneralException;

	public User update(User usr) throws GeneralException;

	public List<User> getAllUser();

	public User deleteUser(Long userId) throws GeneralException;

	public User findByEmail(String userMail);

	public User findUserById(Long userId) throws GeneralException;

	public List<Role> getUserRolesList(Long userId) throws GeneralException;

	public boolean existsById(Long userId) throws GeneralException;

	public User updateUserPassword(Long userId, String olpPassword, String newPassword) throws GeneralException;

	public User findById(Long id);

	public void sendMailToResetPassword(String sender, String toEmail, String body, String subject);

	public Boolean updateUserStatus(User user);
}
