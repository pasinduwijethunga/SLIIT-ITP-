package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.TeaProduct;
import Service.BookService;
import Service.BookServiceImpl;

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
		
		TeaProductService BooksService = new TeaProductServiceImpl();
		
		try {
			TeaProduct BooksList = BooksService.SearchBooks(name);
			
			String url = "assets/BOOKS/MALL/"+BooksList.getPhoto();
			System.out.println("Url "+url);
			
			if(BooksList != null) {
				PrintWriter write = response.getWriter();
				
		
				write.println("<tr>");
				write.println("<td>"+BooksList.getBookId()+"</td>");
				write.println("<td>"); 
				write.println("<div class=\"img-container\" style=\"width: 100px; height: 100px;\">");
				
				write.println("<img src="+url+" alt=\"...\">");
				write.println("</div>");
				write.println("</td>");
				write.println("<td>"+BooksList.getBookName());
				//write.println("<%=b.getBookName() %>");
				write.println("</td>");
				write.println("<td>"+BooksList.getBookauthor()+"</td>");
				write.println("<td>"+BooksList.getBookCategory()+"</td>");
				write.println("<td>"+BooksList.getBookPrice()+"</td>");
				write.println("<td>");
//				write.println("<form action=\"GetIdUpdateBookServlet\" method=\"post\">");
//				write.println("<input type=\"hidden\" name=\"updateBookId\" value=\"<%=b.getBookId() %>\">");
//				write.println("<input type=\"hidden\" name=\"updateBookName\" value=\"<%=b.getBookName() %>\">");
//				write.println("<input type=\"hidden\" name=\"updateBookAuthor\" value=\"<%=b.getBookauthor() %>\">");
//				write.println("<input type=\"hidden\" name=\"updateBookCategory\" value=\"<%=b.getBookCategory() %>\">");
//				write.println("<input type=\"hidden\" name=\"updateBookPrice\" value=\"<%=b.getBookPrice() %>\">");
//				write.println("<button  type=\"submit\" value=\"Save\" rel=\"tooltip\" class=\"btn btn-success btn-round btn-just-icon btn-sm\"  data-toggle=\"tooltip\" data-placement=\"top\" title=\"Edit\" data-container=\"body\">");
//				write.println("<i class=\"material-icons\" style=\"color : white;\">edit</i>");
//				write.println("</button>");
//			    write.println("</form>");
//				write.println("<form action=\"DeleteBookServlet\" method=\"post\">");
//				write.println("<input type=\"hidden\" name=\"deleteValue\" value=\"<%=b.getBookId() %>\" />");
//				write.println("<button rel=\"tooltip\" class=\"btn btn-danger btn-round btn-just-icon btn-sm\"  data-toggle=\"tooltip\" data-placement=\"top\" title=\"Delete\">");
//				write.println("<i class=\"material-icons\" style=\"color : white;\">close</i>");
//			    write.println("</button>");
//				write.println("</form>");         
				write.println("</td>");
				write.println("</tr>");
				

				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
