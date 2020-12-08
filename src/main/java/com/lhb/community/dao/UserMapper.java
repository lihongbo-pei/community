package com.lhb.community.dao;

import com.lhb.community.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author littlelee
 * @date 2020/12/4 16:09
 */
@Mapper
public interface UserMapper {

    User selectById(int id);

    User selectByName(String username);

    User selectByEmail(String email);

    int insertUser(User user);

    int updateStatus(int id,int status);

    int updateHeader(int id,String headerUrl);

    int updatePassword(int id,String password);


}
