package kr.ac.computereng.labmanager.common.datatype;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserRoleTest {

	@Test
	public void 생성자테스트() {
		UserRole userrole = new UserRole("test1");
		assertEquals(Role.YET, userrole.getRole());
	}

	@Test
	public void 생성자테스트2() {
		UserRole userrole = new UserRole("test1",Role.STUDENT);
		assertEquals(Role.STUDENT, userrole.getRole());
	}
}
