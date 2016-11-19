package ch.lauzhack.triphub.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Root extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Root() 
    {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		boolean startSet = false;
		if(request.getParameter("startNb") != null)
		{
			int starts = Integer.parseInt(request.getParameter("startNb"));
			startSet = true;
			request.setAttribute("startNb", starts);
		}
		request.setAttribute("startSet", startSet);
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/form.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
