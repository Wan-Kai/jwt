package com.nethomework.jwt.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.nethomework.jwt.domain.Administrator;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "AdministratorMapper")
public interface AdministratorMapper extends BaseMapper<Administrator> {
    String selectMaxId();
    List<Administrator> selectEqualName(@Param("username") String username);
}
