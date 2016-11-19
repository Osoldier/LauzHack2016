package ch.lauzhack.triphub.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

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
		String date = request.getParameter("date");
		ArrayList<String> starts = new ArrayList<>();
		ArrayList<Calendar> dates = new ArrayList<>();
		boolean proceed = true;
		
		if(destination.equals(""))
		{
			request.setAttribute("errorDest", true);
			request.setAttribute("startSet", true);
			proceed = false;
		}
		
		if(date.equals(""))
		{
			request.setAttribute("errorDate", true);
			request.setAttribute("startSet", true);
			proceed = false;
		}
		
		for(String s : request.getParameterValues("start"))
		{
			if(!s.equals(""))
				starts.add(s);
		}
		
		System.out.println(date);
		for(String s : request.getParameterValues("time"))
		{
			System.out.println(s);
			Calendar cal = new Calendar(s);
		}

		if(starts.size() <= 0)
		{
			request.setAttribute("errorStart", true);
			request.setAttribute("startSet", true);
			proceed = false;
		}
		
		if(!proceed)
		{
			this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/form.jsp").forward(request, response);
			return;
		}
		
		System.out.println("AOK");
		System.out.println(starts.toString());
	}

}
