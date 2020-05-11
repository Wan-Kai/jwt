package com.nethomework.jwt.service;

import com.nethomework.jwt.domain.Administrator;

public interface AdministratorService {
    //管理员注册
    int register(Administrator administrator) throws Exception;
}
