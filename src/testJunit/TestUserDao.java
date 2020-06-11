package testJunit;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import logic.dao.UserDao;

class TestUserDao {

	@Test
	void testFindExistingUsername() {
		boolean result = UserDao.findExistingUsername("robpr");
		assertTrue(result);
	}

}
