package testJunit;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import logic.bean.CocktailBean;
import logic.controller.FindCocktailController;
import logic.model.Cocktail;

class TestFindCocktailController {

	@Test
	void findCocktailWithNameTest() {
		FindCocktailController findCocktailController = new FindCocktailController();
		CocktailBean cocktailNameBean = new CocktailBean();
		String c = "Francesca";
		Cocktail cocktail = new Cocktail(null, c, null, null, null, 0, null);
		List<Cocktail> cocktails = new ArrayList<Cocktail>();
		cocktails.add(cocktail);
		cocktailNameBean.setName(c);
		List<Cocktail> cocktailList = findCocktailController.findCocktailWithName(cocktailNameBean);
		assertEquals(cocktails.get(0).getName(), cocktailList.get(0).getName());
		
	}

}
