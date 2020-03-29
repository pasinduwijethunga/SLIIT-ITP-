package Servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.TeaProduct;
import Service.impl.TeaProductServiceImpl;
import Services.TeaProductService;



/**
 * Servlet implementation class SearchBookServlet
 */
@WebServlet("/SearchBookServlet")
public class SearchTeaProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchTeaProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("searchVideo");
		System.out.println("fff"+name);
		
		TeaProductService tProductService = new TeaProductServiceImpl();
		
		try {
			TeaProduct TeaList = tProductService.SearchTeas(name);
			
			String url = "assets/BOOKS/MALL/"+TeaList.getPhoto();
			System.out.println("Url "+url);
			
			if(TeaList != null) {
				PrintWriter write = response.getWriter();
				
		
				write.println("<tr>");
				write.println("<td>"+TeaList .getTeaId()+"</td>");
				write.println("<td>"); 
				write.println("<div class=\"img-container\" style=\"width: 100px; height: 100px;\">");
				
				write.println("<img src="+url+" alt=\"...\">");
				write.println("</div>");
				write.println("</td>");
				write.println("<td>"+TeaList .getTeaCode());
				
				write.println("</td>");
				write.println("<td>"+TeaList .getTeaCode()+"</td>");
				write.println("<td>"+TeaList .getTeaCategory()+"</td>");
				write.println("<td>"+TeaList .getTeaPrice()+"</td>");
				write.println("<td>");        
				write.println("</td>");
				write.println("</tr>");
				

				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
