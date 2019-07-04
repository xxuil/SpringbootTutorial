package com.learn.springboot.mapper;

import com.learn.springboot.pojo.LoginLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginLogMapper {
    @Insert("insert into login_log (lid, userId, loginTime, ip, device) values (#{lid}, #{userId}, #{loginTime}, #{ip}, #{device})")
    void add(LoginLog loginLog);
}
