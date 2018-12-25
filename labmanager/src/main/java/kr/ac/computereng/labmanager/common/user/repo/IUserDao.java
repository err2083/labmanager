package kr.ac.computereng.labmanager.common.user.repo;

import java.util.List;

import kr.ac.computereng.labmanager.common.datatype.UserDatatype;
import kr.ac.computereng.labmanager.common.datatype.UserRole;

public interface IUserDao {
	/**
	 * 유저를 디비에 추가하기
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int add(UserDatatype user) throws Exception;	//user table add
	
	/**
	 * 권한을 디비에 추가하기
	 * @param userrole
	 * @return
	 * @throws Exception
	 */
	public int addRole(UserRole userrole) throws Exception; //role table add

	/**
	 * 아이디로 회원 찾기
	 * @param id
	 * @return UserDatatype
	 * @throws Exception
	 */
	public UserDatatype selectOne(String id) throws Exception;
	
	/**
	 * 모든 유저를 가져오기
	 * @return List<UserDatatype>
	 * @throws Exception
	 */
	public List<UserDatatype> selectAll() throws Exception;
	
	/**
	 * 아이디로 유저 디비에서 삭제하기
	 * @param id
	 * @throws Exception
	 */
	public void delete(String id) throws Exception;
	
	/**
	 * 아이디로 유저 권한 디비에서 삭제하기
	 * @param string
	 * @throws Exception
	 */
	public void deleteRole(String id) throws Exception;
	
	/**
	 * 유저정보를 받아서 업데이트하기
	 * @param user
	 * @throws Exception
	 */
	public void update(UserDatatype user) throws Exception;

	/**
	 * 유저권한을 유저에게 부여하기
	 * @param userrole
	 * @throws Exception
	 */
	public void authorize(UserRole userrole) throws Exception;
	
	/**
	 * 아이디로 유저한명의 권한 검색하기
	 * @param id
	 * @return UserRole
	 * @throws Exception
	 */
	public UserRole selectOneRole(String id) throws Exception;
}

