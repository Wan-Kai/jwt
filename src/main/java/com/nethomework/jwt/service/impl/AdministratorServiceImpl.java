package com.nethomework.jwt.service.impl;

import com.nethomework.jwt.mapper.AdministratorMapper;
import com.nethomework.jwt.domain.Administrator;
import com.nethomework.jwt.service.AdministratorService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("administratorService")
public class AdministratorServiceImpl implements AdministratorService  {
    @Autowired
    private AdministratorMapper mapper;

    @Override
    public int register(Administrator administrator) throws Exception {
        List<Administrator> username = mapper.selectEqualName(administrator.getUsername());
        int length = username.size();
        if (length == 0) {
            //id自增
            String id = mapper.selectMaxId();
            int idNum = Integer.parseInt(id) + 1;
            administrator.setUserId(String.format("%d", idNum));
            administrator.setSessionId(String.format("%d", idNum));
            mapper.insert(administrator);
            return 0;
        } else {
            return 1;
        }
    }
}
