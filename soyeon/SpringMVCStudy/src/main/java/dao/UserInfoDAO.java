package dao;

public interface UserInfoDAO {
	
	public UserInfo findUserInfo(String userName);
	
	public List<String> getUserRoles(String userName);
	
}
