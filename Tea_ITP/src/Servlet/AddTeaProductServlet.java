package Servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.TeaProduct;
import Service.impl.TeaProductServiceImpl;
import Services.TeaProductService;

/**
 * Servlet implementation class AddBooksServlet
 */
@WebServlet("/AddBooksServlet")
public class AddTeaProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTeaProductServlet() {
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
		
		String teaid = request.getParameter("ID"); 
		String teacode = request.getParameter("Code");
		String teaname = request.getParameter("Name");
		String teacategory = request.getParameter("Category");
		double teaprice = Double.parseDouble(request.getParameter("Price")); 
		String teastatus = request.getParameter("Status");
		String teadescrip = request.getParameter("Descrip");
		double teaweight = Double.parseDouble(request.getParameter("Weight"));
		String photo = request.getParameter("photo");
		
		
		TeaProduct tea = new TeaProduct();
		
		tea.setTeaId(teaid);
		tea.setTeaCode(teacode);
		tea.setTeaName(teaname);
		tea.setTeaCategory(teacategory);
		tea.setTeaPrice(teaprice);
		tea.setTeaStatus(teastatus);
		tea.setTeaDescrip(teadescrip);
		tea.setTeaWeight(teaweight);
		tea.setPhoto(photo);
		
		TeaProductService bkService = new TeaProductServiceImpl();
		
		try {
			boolean isAdded = bkService.addNewTea(tea);
			
			if(isAdded == true) {
				System.out.println("Successfully Added a book !");
				
				PrintWriter out = response.getWriter();
				out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
				out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
				out.println("<script>");
				out.println("$(document).ready(function(){");
				out.println("swal ( 'Added Successfully' ,  '' ,  'success' );");
				out.println("});");
				out.println("</script>"); 
				
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AdminView.jsp");
				dispatcher.include(request, response);
				
			}
			else {
				

				PrintWriter out = response.getWriter();
				out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
				out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
				out.println("<script>");
				out.println("$(document).ready(function(){");
				out.println("swal ( 'Wrong Entry !' ,  '' ,  'error' );");
				out.println("});");
				out.println("</script>"); 
				
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AdminInsert.jsp");
				dispatcher.include(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
