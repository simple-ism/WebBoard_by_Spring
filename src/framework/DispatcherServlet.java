/*
 * url 패턴 : 
 *  /board/list.do -> BoardListController 
 *  /board/write.do -> BoardWriteController
 *  
 *   command 패턴 :
 *   /board.do?type= list  -> BoardListController
 *   /board.do?type= write-> BoardWriteController
 * 
 * 사용자의 요청을 받고 
 * 요청에 해당하는 작업 컨트롤러 클래스를 호출하고
 * 작업클래스에서 실행한 결과를 
 * 적절한 사용자 화면 페이지를 호출하여 사용할 수 있게 한다.
 * 
 * 
 * 추후..
 * 자동 파라미터 처리 
 * 사용자 요청 작업 클래스를 검색하는 부분을 효율적으로 변경
 * 
 * 
 */


package framework;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.controller.ListController;



public class DispatcherServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//현재 프로직트 경로 찾기
		ServletContext sc = request.getServletContext();
		/*
		String contextPath = sc.getContextPath();
		
		System.out.println("contextPath : " + contextPath);
		*/
		String contextPath = request.getContextPath();
				System.out.println("contextPath : " + contextPath);
				
		String requestUri = request.getRequestURI();
//		System.out.println("requestUri : " + requestUri);
		
		
		requestUri = requestUri.substring(contextPath.length());
		System.out.println("requestUri : " + requestUri);
		
		String view="";
		switch(requestUri){
		case "/board/list.do":
				ListController list = new ListController();
				view = list.execute(request, response);
			break;
		}
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	
}
