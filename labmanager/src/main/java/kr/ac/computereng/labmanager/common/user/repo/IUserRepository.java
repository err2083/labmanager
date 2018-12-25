package kr.ac.computereng.labmanager.common.user.repo;

import java.util.List;

import kr.ac.computereng.labmanager.common.datatype.UserDatatype;
import kr.ac.computereng.labmanager.common.datatype.UserRole;
import kr.ac.computereng.labmanager.common.datatype.Role;

public interface IUserRepository {
	/**
	 * 유저를 추가하기
	 * @param user
	 * @return boolean
	 * @throws Exception
	 */
	public boolean addUser(UserDatatype user) throws Exception;
	
	/**
	 * 유저아이디로 유저 검색하기
	 * @param id
	 * @return UserDatatype
	 * @throws Exception
	 */
	public UserDatatype selectOne(String id) throws Exception;
	
	/**
	 * 모든 유저 검색하기
	 * @return List<UserDatatype>
	 * @throws Exception
	 */
	public List<UserDatatype> selectAll() throws Exception;
	
	/**
	 * 아이디로 유저 삭제하기
	 * @param string
	 * @return
	 * @throws Exception
	 */
	public boolean delete(String id) throws Exception;
	
	/**
	 * 유저정보 받아서 업데이트하기
	 * @param user
	 * @return boolean
	 * @throws Exception
	 */
	public boolean update(UserDatatype user) throws Exception;
	
	/**
	 * 유저 아이디에 주어진 권한 부여하기
	 * @param id
	 * @param role
	 * @return boolean
	 * @throws Exception
	 */
	public boolean authorize(String id,Role role) throws Exception;
	
	/**
	 * 아이디로 유저 한명 권한 검색하기
	 * @param id
	 * @return UserRole
	 * @throws Exception
	 */
	public UserRole selectOneRole(String id) throws Exception;
	
	/**
	 * 유저 권한 디비에 추가하기
	 * @param user
	 * @return boolean
	 * @throws Exception
	 */
	public boolean addRole(UserRole user) throws Exception;
	
	/**
	 * 아이디로 유저 권한 삭제하기
	 * @param id
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteRole(String id) throws Exception;
}
