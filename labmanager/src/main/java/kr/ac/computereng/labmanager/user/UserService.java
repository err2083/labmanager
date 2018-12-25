package kr.ac.computereng.labmanager.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.computereng.labmanager.common.datatype.Role;
import kr.ac.computereng.labmanager.common.datatype.UserDatatype;
import kr.ac.computereng.labmanager.common.datatype.UserRole;
import kr.ac.computereng.labmanager.common.user.IUserService;
import kr.ac.computereng.labmanager.common.user.repo.IUserRepository;

@Service
public class UserService implements IUserService {
	@Autowired
	private IUserRepository userRepository;

	@Override
	@Transactional(rollbackFor=Exception.class)
	public boolean joinUser(UserDatatype user) throws Exception {
		UserRole userrole = new UserRole(user.getId());
		boolean conditionUser = this.userRepository.addUser(user);
		if(conditionUser == false) return false;
		boolean conditionRole = this.userRepository.addRole(userrole);
		if(conditionRole == false) return false;
		return true;
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public boolean withdraw(String id) throws Exception {
		boolean conditionUser = this.userRepository.delete(id);
		if(conditionUser == false) return false;
		boolean conditionRole = this.userRepository.deleteRole(id);
		if(conditionRole == false) return false;
		return true;
	}

	@Override
	public boolean updateUser(UserDatatype user) throws Exception {
		return this.userRepository.update(user);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public UserDatatype searchOne(String id) throws Exception {
		UserDatatype user = this.userRepository.selectOne(id);
		if(user == null)
			return null;
		user.setRole(this.userRepository.selectOneRole(id));
		return user;
	}

	@Override
	public boolean authorize(String id, Role role) throws Exception {
		return this.userRepository.authorize(id, role);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public List<UserDatatype> search() throws Exception {
		List<UserDatatype> userAll = this.userRepository.selectAll();
		for(int i=0;i<userAll.size();i++) {
			userAll.get(i).setRole(this.userRepository.selectOneRole(userAll.get(i).getId()));
		}
		return userAll;
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public UserDatatype login(String id, String password) throws Exception {
		// TODO Auto-generated method stub
		if(this.searchOne(id) == null || this.searchOne(id).getPassword().equals(password) == false) //아이디가 없을 경우,비밀번호 다른경우
			return null;
		return this.searchOne(id);
	}
	
}
