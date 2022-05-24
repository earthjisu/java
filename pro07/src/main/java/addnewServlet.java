

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addnewServlet
 */
@WebServlet("/addnew")
public class addnewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addnewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String pw=request.getParameter("password");
 		       //pw:서블릿의 변수이름(임의로 설정)//password:클라이언트 내부와 일치시켜야함
		MemberVO mvo =new MemberVO();
		mvo.setId(request.getParameter("id"));
		mvo.setPwd(request.getParameter("password"));
		mvo.setName(request.getParameter("name"));
		mvo.setMobile(request.getParameter("mobile"));
		mvo.setJoinDate(request.getParameter("joindate"));
		MemberDAO dao=new MemberDAO();
		dao.addnewMember(mvo);
//		response.sendRedirect("member");
		PrintWriter out = response.getWriter();
		out.print("<html><body></body><script>document.location='http://localhost:8080/pro07/member';</script></html>");
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
