package testJunit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import logic.bean.LoginBean;
import logic.controller.LoginController;

class TestLoginController {

	@Test
	void testFindIdentity() {
		LoginController c = LoginController.getInstance();
		LoginBean bean = new LoginBean();
		bean.setUsername("robpr");
		bean.setPassword("password");
		c.setBean(bean);
		boolean result = c.findIdentity();
		assertTrue(result);
	}

}
