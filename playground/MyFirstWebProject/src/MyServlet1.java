

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MyServlet1")
public class MyServlet1 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside the servlet");
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String enteredAge = request.getParameter("age");
		
		out.println("<h1>The entered age is " + enteredAge + "</h1>");
		
		MainLogicClass obj = new MainLogicClass();
		String result = obj.checkAge(Integer.parseInt(enteredAge));
		out.println("You are actually a " + result);
		
	}

}
