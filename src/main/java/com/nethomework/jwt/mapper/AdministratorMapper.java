package com.nethomework.jwt.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.nethomework.jwt.domain.Administrator;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AdministratorMapper{
    String selectMaxId();
    List<Administrator> selectEqualName(@Param("username") String username);
}
