package login;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import framework.Controller;

@WebServlet("/login/loginForm")
public class LoginFormController implements Controller {

	
	public String execute(
			HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		
				
		return "loginForm.jsp";
			
	}
}
















