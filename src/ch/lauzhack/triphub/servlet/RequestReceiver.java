package ch.lauzhack.triphub.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet(description = "Get request and launches algorithm", urlPatterns = { "/request" })
public class RequestReceiver extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public RequestReceiver() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.sendError(403);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		//HttpSession session = request.getSession();
		String destination = request.getParameter("dest");
		ArrayList<String> starts = new ArrayList<>();
		if(destination.equals(""))
		{
			request.setAttribute("errorDest", true);
			request.setAttribute("startSet", true);
			this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/form.jsp").forward(request, response);
			return;
		}
		
		for(String s : request.getParameterValues("start"))
		{
			if(!s.equals(""))
				starts.add(s);
		}

		if(starts.size() <= 0)
		{
			request.setAttribute("errorStart", true);
			request.setAttribute("startSet", true);
			this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/form.jsp").forward(request, response);
			return;
		}
		
		System.out.println("AOK");
		System.out.println(starts.toString());
	}

}
