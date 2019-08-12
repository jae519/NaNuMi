package kr.or.kftc.jaehuyn.Nanumi.dao;

import java.util.List;

import kr.or.kftc.jaehuyn.Nanumi.model.UserInfo;

public interface UserInfoDAO {
    
    public UserInfo findUserInfo(String userName);
     
    // [USER,AMIN,..]
    public List<String> getUserRoles(String userName);
     
}