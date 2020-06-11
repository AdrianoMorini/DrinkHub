package testJunit;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import logic.bean.BarUserBean;
import logic.bean.FindUserBean;
import logic.controller.FindBarUserController;
import logic.exception.StringIsEmptyException;

class TestFindBarUserController {

	@Test
	void isInsertedBarUsernameValidTest() throws StringIsEmptyException {
		FindBarUserController findBarUserController = FindBarUserController.getInstance();
		BarUserBean barUserBean = new BarUserBean();
		String a = "a";
		barUserBean.setBarUsername(a);
		Boolean t = findBarUserController.isInsertedBarUsernameValid(barUserBean);
		assertTrue(t);
	}
	
	@Test
	void isInsertedUserUsernameValidTest() throws StringIsEmptyException {
		FindBarUserController findBarUserController = FindBarUserController.getInstance();
		FindUserBean findUserBean = new FindUserBean();
		String usname = "Luciano";
		findUserBean.setUsername(usname);
		Boolean f = findBarUserController.isInsertedUserUsernameValid(findUserBean);
		assertFalse(f);
		}

}
