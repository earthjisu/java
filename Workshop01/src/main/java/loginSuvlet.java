

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginSuvlet
 */
@WebServlet("/login")
public class loginSuvlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginSuvlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		String user_id=request.getParameter("user_id");
		String user_pw=request.getParameter("user_pw");
//		String[] subject=request.getParameterValues("subject");
		
		System.out.println("GET 아이디:"+user_id); //eclipse의 console창에 표시
		System.out.println("GET 비밀번호:"+user_pw);
		response.getWriter().print(user_id+"반갑습니다<br>");  //웹브라우저(크롬)에 표시(출력)
		response.getWriter().print("GET 비밀번호:"+user_pw+"<br>");
//		response.getWriter().print("관심분야:");
//		
//		for(String str:subject) {    //for(값을 받을 변수 : 값을 보낼 배열명)
//			response.getWriter().print(str+",");
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html; charset=utf-8");
		String user_id=request.getParameter("user_id");
		String user_pw=request.getParameter("user_pw");
		
		System.out.println("POST 아이디:"+user_id); //eclipse의 console창에 표시
		System.out.println("POST 비밀번호:"+user_pw);
		response.getWriter().print("POST 아이디:"+user_id);  //웹브라우저(크롬)에 표시(출력)
		response.getWriter().print("POST 비밀번호:"+user_pw);
	}

}
