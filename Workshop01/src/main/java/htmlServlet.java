

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class htmlServlet
 */
@WebServlet("/html")
public class htmlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public htmlServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String htmlStr="<!DOCTYPE html><html><head><meta charset='UTF-8'><title>�α��� â</title>"+
				"</head><body><form name=frmLogin method=get action=login encType='uft-8'><br>"+
				"���̵�:<input type=text name=user_id><br>��й�ȣ:<input type=password name=user_pw><br>"+
				"<input type=submit value='�α���'><input type=reset value='�ٽ��Է�'></form>"+"</body>"+"</html>";
		out.print(htmlStr);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
