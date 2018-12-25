package kr.ac.computereng.labmanager.common.datatype;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserDatatypeTest {

	@Test
	public void 생성자테스트() {
		UserDatatype userdata = new UserDatatype("id","password","name","email1","email2","study","hope");
		assertEquals(userdata.getId(), "id");
		assertEquals(userdata.getPassword(), "password");
		assertEquals(userdata.getName(), "name");
		assertEquals(userdata.getEmail1(),"email1");
		assertEquals(userdata.getEmail2(),"email2");
		assertEquals(userdata.getRole().getRole(),Role.YET);
		assertEquals(userdata.getStudy(),"study");
		assertEquals(userdata.getHope(),"hope");
	}
}
