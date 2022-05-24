

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class workServlet
 */
@WebServlet("/workServlet")
public class workServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public workServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//query string 사용 사칙연산
		//workServlet?op=plus/minus/multi/div&val1=10&val2=4
		String strop=request.getParameter("op");
		String val1=request.getParameter("val1");
		String val2=request.getParameter("val2");
		int n=Integer.parseInt(val1);
		int m=Integer.parseInt(val2);
		if(strop==null) return;
		if(strop.equals("plus")) {   //문자열 비교시 .equals
			response.getWriter().append(val1+"+"+val2+"="+(n+m));			
		}else if(strop.equals("minus")) {
			response.getWriter().append(val1+"-"+val2+"="+(n-m));
		}else if(strop.equals("multi")) {
			response.getWriter().append(val1+"x"+val2+"="+(n*m));
		}else if(strop.equals("div")) {
			response.getWriter().append(val1+"/"+val2+"="+(n/m));
		}		
//		   //풀이
//			String op=request.getParameter("op");
//			if(op==null) return;
//			int val1=Integer.parseInt(request.getParameter("val1"));
//			int val2=Integer.parseInt(request.getParameter("val2"));
//			int result=0;
//			if(op.equals("plus")) {
//				result=val1+val2;
//			}else if(op.equals("minus")) {
//				result=val1-val2;
//			}else if(op.equals("multi")) {
//				result=val1*val2;
//			}else if(op.equals("div")) {
//				result=(int) (val1/val2);
//			}
//			response.getWriter().append("result="+result);
	}  
	


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
