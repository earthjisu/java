

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class gcdServlet
 */
@WebServlet("/gcdServlet")
public class gcdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public gcdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int val1=Integer.parseInt(request.getParameter("val1"));
		int val2=Integer.parseInt(request.getParameter("val2"));
	    int x=0;
	    int gcd=0;
	    if(val1>val2) {
	    	x=val1;
	    	val1=val2;
	    	val2=x;	    	
	    }
		for(int i=val1;i>=2;i-- ) {
			if (val1%i==0 && val2%i==0) {
				gcd=i;
				val1=val1/i;
				val2=val2/i;
			}
		}
		
		response.getWriter().append("gcd="+gcd+"\n");
		response.getWriter().append("min="+gcd*val1*val2);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
