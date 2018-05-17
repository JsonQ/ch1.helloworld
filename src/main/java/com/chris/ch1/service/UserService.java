package com.chris.ch1.service;

import com.chris.ch1.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService implements IUserService {

    @Override
    public User getUserById(Long id) {
        return null;
    }
}
