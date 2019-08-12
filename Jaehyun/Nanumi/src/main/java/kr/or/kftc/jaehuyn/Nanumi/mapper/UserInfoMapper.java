package kr.or.kftc.jaehuyn.Nanumi.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import kr.or.kftc.jaehuyn.Nanumi.model.UserInfo;  


public class UserInfoMapper implements RowMapper<UserInfo> {
	 
    public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
 
        String userName = rs.getString("Username");
        String password = rs.getString("Password");
 
        return new UserInfo(userName, password);
    }
 
}
