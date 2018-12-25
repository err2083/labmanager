package kr.ac.computereng.labmanager.user.repo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.computereng.labmanager.common.datatype.UserDatatype;
import kr.ac.computereng.labmanager.common.datatype.UserRole;
import kr.ac.computereng.labmanager.common.datatype.Role;
import kr.ac.computereng.labmanager.common.user.repo.IUserDao;
import kr.ac.computereng.labmanager.common.user.repo.IUserRepository;

@Repository
public class UserRepository implements IUserRepository {
	
	@Autowired
	private IUserDao userDao;

	@Override
	public boolean addUser(UserDatatype user) throws Exception {
		// TODO Auto-generated method stub
		UserDatatype condition = userDao.selectOne(user.getId());	//테이블에 이미 있는지 확인
		if(condition != null) return false;		//만일 condition 이 비어있지 않는다면 이미 있으므로 false
		int result = this.userDao.add(user);	//그렇지 않으면 로직 수행
		if(result == 0)
			return false;
		else 
			return true;
	}

	@Override
	public UserDatatype selectOne(String id) throws Exception {
		// TODO Auto-generated method stub
		return userDao.selectOne(id);
	}

	@Override
	public List<UserDatatype> selectAll() throws Exception {
		// TODO Auto-generated method stub
		return userDao.selectAll();
	}

	@Override
	public boolean delete(String id) throws Exception {
		// TODO Auto-generated method stub
		if(this.selectOne(id) == null) {
			return false;
		}
		userDao.delete(id);
		return true;
	}

	@Override
	public boolean update(UserDatatype user) throws Exception {
		// TODO Auto-generated method stub
		if(this.selectOne(user.getId()) == null) {
			return false;
		}
		userDao.update(user);
		return true;
	}

	@Override
	public boolean authorize(String id, Role role) throws Exception {
		// TODO Auto-generated method stub
		if(this.selectOne(id) == null) {
			return false;
		}
		UserRole userrole = new UserRole(id,role);
		userDao.authorize(userrole);
		return true;
	}

	
	
	@Override
	public UserRole selectOneRole(String id) throws Exception {
		return userDao.selectOneRole(id);
	}

	@Override
	public boolean addRole(UserRole user) throws Exception {
		UserRole condition = userDao.selectOneRole(user.getId());	//테이블에 이미 있는지 확인
		if(condition != null) return false;		//만일 condition 이 비어있지 않는다면 이미 있으므로 false
		int result = this.userDao.addRole(user);	//그렇지 않으면 로직 수행
		if(result == 0)
			return false;
		else 
			return true;
	}
	
	@Override
	public boolean deleteRole(String id) throws Exception {
		// TODO Auto-generated method stub
		if(this.selectOneRole(id) == null) {
			return false;
		}
		userDao.deleteRole(id);
		return true;
	}

}
