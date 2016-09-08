package login;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import framework.Controller;
import framework.ModelAndView;

@WebServlet("/login/loginForm")
public class LoginFormController implements Controller {

	
	public ModelAndView execute(
			HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		
		ModelAndView mav = new ModelAndView();
		mav.setView("loginForm.jsp");
		return mav;
			
	}
}
















