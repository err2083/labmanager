package kr.ac.computereng.labmanager.common.user;

import java.util.List;

import kr.ac.computereng.labmanager.common.datatype.Role;
import kr.ac.computereng.labmanager.common.datatype.UserDatatype;

public interface IUserService {
	
	/**
	 * 로그인하기
	 * @param id
	 * @param password
	 * @return UserDatatype
	 * @throws Exception
	 */
	public UserDatatype login(String id,String password) throws Exception;
	
	/**
	 * 회원 추가하기
	 * @param user
	 * @return boolean
	 * @throws Exception
	 */
	public boolean joinUser(UserDatatype user) throws Exception;
	
	/**
	 * 회원탈퇴하기
	 * @param id
	 * @return boolean
	 * @throws Exception
	 */
	public boolean withdraw(String id) throws Exception;
	
	/**
	 * 회원정보수정하기
	 * @param user
	 * @return boolean
	 * @throws Exception
	 */
	public boolean updateUser(UserDatatype user) throws Exception;
	
	/**
	 * 회원한명정보검색하기
	 * @param id
	 * @return UserDatatype
	 * @throws Exception
	 */
	public UserDatatype searchOne(String id) throws Exception;
	
	/**
	 * 회원권한부여
	 * @param id
	 * @param role
	 * @return boolean
	 * @throws Exception
	 */
	public boolean authorize(String id,Role role) throws Exception;
	
	/**
	 * 회원전체가져오기
	 * @return List<UserDatatype>
	 * @throws Exception
	 */
	public List<UserDatatype> search() throws Exception;
}
