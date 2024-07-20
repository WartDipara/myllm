package com.ela.myLLM.service;

import com.ela.myLLM.entity.User;
import com.ela.myLLM.ui.vo.Result;

public interface UserService {
    public User login(User user);
    public User register(User user);
}
