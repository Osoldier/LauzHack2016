package ch.lauzhack.triphub.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(description = "Get request and launches algorithm", urlPatterns = { "/request" })
public class RequestReceiver extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public RequestReceiver() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.sendError(403);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("AOK");
	}

}
