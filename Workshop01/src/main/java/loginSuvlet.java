

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
		
		System.out.println("GET ���̵�:"+user_id); //eclipse�� consoleâ�� ǥ��
		System.out.println("GET ��й�ȣ:"+user_pw);
		response.getWriter().print(user_id+"�ݰ����ϴ�<br>");  //��������(ũ��)�� ǥ��(���)
		response.getWriter().print("GET ��й�ȣ:"+user_pw+"<br>");
//		response.getWriter().print("���ɺо�:");
//		
//		for(String str:subject) {    //for(���� ���� ���� : ���� ���� �迭��)
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
		
		System.out.println("POST ���̵�:"+user_id); //eclipse�� consoleâ�� ǥ��
		System.out.println("POST ��й�ȣ:"+user_pw);
		response.getWriter().print("POST ���̵�:"+user_id);  //��������(ũ��)�� ǥ��(���)
		response.getWriter().print("POST ��й�ȣ:"+user_pw);
	}

}
