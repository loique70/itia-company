package com.itia.sitevitrine.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.itia.sitevitrine.beans.User;

@Service
public class UserMapper {

    public enum DATEFORMAT {
        DAYMONTHYEAR,
        MONTHYEAR,
        YEAR
    }

    public static List<User> map(Page<User> userPage) {
        List<User> dtos = new ArrayList<User>();
        for (User user : userPage) {
            dtos.add(user);
        }
        return dtos;
    }
}
