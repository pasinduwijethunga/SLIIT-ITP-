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
 * Servlet implementation class updateBookServlet
 */
@WebServlet("/updateBookServlet")
public class updateTeaProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateTeaProductServlet() {
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
		
		String teaid = request.getParameter("");
		String teacode = request.getParameter("");
		String teaname= request.getParameter("");
		String teacategory = request.getParameter("");
		String Category = request.getParameter("");
		double price = Double.parseDouble(request.getParameter(""));
		String teastatus = request.getParameter("");
		String teadescrip = request.getParameter("");
		String teaphoto = request.getParameter("");
		double teaweight = Double.parseDouble(request.getParameter(""));
		
		TeaProduct t1 = new TeaProduct();
		
		t1.setTeaId(teaid);
		t1.setTeaCode(teacode);
		t1.setTeaName(teaname);
		t1.setTeaCategory(teacategory);
		t1.setTeaPrice(price);
		t1.setTeaStatus(teastatus);
		t1.setTeaDescrip(teadescrip);
		t1.setPhoto(teaphoto);
		t1.setTeaWeight(teaweight);
		
		
		TeaProductService itea = new TeaProductServiceImpl();
		
		try {
			boolean isUpdated = itea.updateDelivery(t1);
			
			if(isUpdated == true) {
				System.out.println("Successfully Updated a book !");
				
				PrintWriter out = response.getWriter();
				out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
				out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
				out.println("<script>");
				out.println("$(document).ready(function(){");
				out.println("swal ( 'Updated Successfully' ,  '' ,  'success' );");
				out.println("});");
				out.println("</script>"); 
				
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AdminView.jsp");
				dispatcher.include(request, response);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
