package logic.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.bean.CocktailBean;
import logic.controller.FindCocktailController;
import logic.model.Cocktail;

/**
 * Servlet implementation class Search
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private FindCocktailController cocktailController = new FindCocktailController();
	private String cocktailName = "cocktailName";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Cocktail> cocktails = null;
		if (request.getParameter(cocktailName) == "") {
			request.getSession().setAttribute("searchMessage","Retry. Field name is not correct.");
		}
		else {
			request.getSession().setAttribute("searchMessage","Results for '"+ request.getParameter(cocktailName) +"':");
			String name = request.getParameter(cocktailName);

			CocktailBean cocktailNameBean = new CocktailBean();
			cocktailNameBean.setName(name);
			this.cocktails = this.cocktailController.findCocktailWithName(cocktailNameBean);
			if (cocktails.isEmpty()) {
				//("No cocktail found.")
				request.getSession().setAttribute("listing", "Not found");
				String nextJSP = "/search.jsp";
    			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
    			dispatcher.forward(request,response);
                return;
			}
			request.getSession().setAttribute("listing", "Results for '"+name+"':");
			List<String> cocktailsNameList = new ArrayList<>();
			for (Cocktail ctName : cocktails) {
				cocktailName = ctName.getId() + ", "+ ctName.getName() + ", posted by " + ctName.getCocktailUser();
				cocktailsNameList.add(cocktailName);			
			} 
			
			request.getSession().setAttribute("len", cocktailsNameList.size());
			request.getSession().setAttribute("results", cocktailsNameList);
		}
		response.sendRedirect(request.getHeader("Referer"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
