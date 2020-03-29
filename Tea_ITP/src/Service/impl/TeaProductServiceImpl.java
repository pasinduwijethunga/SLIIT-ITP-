package Service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.Statement;

import Model.TeaProduct;
import Services.TeaProductService;
import Util.DBConnection;

public class TeaProductServiceImpl implements TeaProductService{

	private static Connection conn;
	
	public TeaProductServiceImpl() {

			conn = DBConnection.getConnection();
	}
	
	@Override
	public boolean addNewTeaProduct(TeaProduct tea) throws SQLException {
		
		String sql = "Insert into books values(?,?,?,?,?,?,?,?,now()) ";
		PreparedStatement stm = conn.prepareStatement(sql);
		
		stm.setObject(1, tea.getTeaId());
		stm.setObject(2, tea.getTeaCode());
		stm.setObject(3, tea.getTeaName());
		stm.setObject(4, tea.getTeaCategory());
		stm.setObject(5, tea.getTeaPrice());
		stm.setObject(6, tea.getTeaStatus());
		stm.setObject(7, tea.getTeaDescrip());
		stm.setObject(8, tea.getTeaWeight());
		stm.setObject(9, tea.getTeaPrice());
		
		
		
		int res = stm.executeUpdate();
		
		
		
		
		return res > 0;
	}

	@Override
	public ArrayList<TeaProduct> getAllTeaProduts () throws SQLException {

		String sql = "select * from teaproducts";
		java.sql.Statement  stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(sql);
		ArrayList<TeaProduct> tplist = new ArrayList<TeaProduct>();
		
		
		while(rst.next()) {
			
			TeaProduct tp = new TeaProduct();
			
			tp.setTeaId(rst.getString(""));
			System.out.println("rst.getString(\"bookId\")"+rst.getString(""));
			tp.setTeaCode(rst.getString(""));
			tp.setTeaName(rst.getString(""));
			tp.setTeaCategory(rst.getString(""));
			tp.setTeaPrice(Double.parseDouble(rst.getString("")));
			tp.setPhoto(rst.getString(""));
			
			tplist.add(tp);
			System.out.println("Set"+tp.getTeaId());
		}
		
		return tplist;
	}
	
	
	@Override
	public ArrayList<TeaProduct> getAllBooksNovel() throws SQLException {

		String sql = "select * from books where category='Novels' order by time ";
		java.sql.Statement  stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(sql);
		ArrayList<TeaProduct> bklist = new ArrayList<TeaProduct>();
		
		
		while(rst.next()) {
			
			TeaProduct tp = new TeaProduct();
			
			tp.setTeaId(rst.getString(""));
			tp.setTeaCode(rst.getString(""));
			tp.setTeaName(rst.getString(""));
			tp.setTeaCategory(rst.getString(""));
			tp.setTeaPrice(Double.parseDouble(rst.getString("")));
			tp.setTeaStatus(rst.getString(""));
			tp.setTeaDescrip(rst.getString(""));
			tp.setTeaWeight(Double.parseDouble(rst.getString("")));
			tp.setPhoto(rst.getString(""));
			
			
			tplist.add(tp);
		}
		
		return tplist;
	}
	
	
	@Override
	public ArrayList<TeaProduct> getAllBooksChildren() throws SQLException {

		String sql = "select * from books where category='Children' order by time ";
		java.sql.Statement  stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(sql);
		ArrayList<TeaProduct> bklist = new ArrayList<TeaProduct>();
		
		
		
		while(rst.next()) {
			
			TeaProduct bk = new TeaProduct();
			
			bk.setBookId(rst.getString("bookId"));
			bk.setBookName(rst.getString("bookName"));
			bk.setBookauthor(rst.getString("author"));
			bk.setBookCategory(rst.getString("category"));
			bk.setBookPrice(Double.parseDouble(rst.getString("price")));
			bk.setPhoto(rst.getString("photo"));
			
			
			bklist.add(bk);
		}
		
		return bklist;
	}


	@Override
	public ArrayList<TeaProduct> getAllBooksEducation() throws SQLException {

		String sql = "select * from books where category='Education' order by time ";
		java.sql.Statement  stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(sql);
		ArrayList<TeaProduct> bklist = new ArrayList<TeaProduct>();
		
		
		while(rst.next()) {
			
			TeaProduct bk = new TeaProduct();
			
			bk.setBookId(rst.getString("bookId"));
			bk.setBookName(rst.getString("bookName"));
			bk.setBookauthor(rst.getString("author"));
			bk.setBookCategory(rst.getString("category"));
			bk.setBookPrice(Double.parseDouble(rst.getString("price")));
			bk.setPhoto(rst.getString("photo"));
			
			
			bklist.add(bk);
		}
		
		return bklist;
	}


	@Override
	public ArrayList<TeaProduct> getAllBooksindex() throws SQLException {

		String sql = "select * from books  order by time  limit 3 ";
		java.sql.Statement  stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(sql);
		ArrayList<TeaProduct> bklist = new ArrayList<TeaProduct>();
		
		
		while(rst.next()) {
			
			TeaProduct bk = new TeaProduct();
			
			bk.setBookId(rst.getString("bookId"));
			bk.setBookName(rst.getString("bookName"));
			bk.setBookauthor(rst.getString("author"));
			bk.setBookCategory(rst.getString("category"));
			bk.setBookPrice(Double.parseDouble(rst.getString("price")));
			bk.setPhoto(rst.getString("photo"));
			
			bklist.add(bk);
		}
		
		return bklist;
	}


	@Override
	public ArrayList<TeaProduct> getAllBooksindex2() throws SQLException {

		String sql = "select * from books  order by time  limit 10 ";
		java.sql.Statement  stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(sql);
		ArrayList<TeaProduct> bklist = new ArrayList<TeaProduct>();
		
		
		while(rst.next()) {
			
			TeaProduct bk = new TeaProduct();
			
			bk.setBookId(rst.getString("bookId"));
			bk.setBookName(rst.getString("bookName"));
			bk.setBookauthor(rst.getString("author"));
			bk.setBookCategory(rst.getString("category"));
			bk.setBookPrice(Double.parseDouble(rst.getString("price")));
			bk.setPhoto(rst.getString("photo"));
			
			
			bklist.add(bk);
		}
		
		return bklist;
	}
	
	

	@Override
	public boolean deleteBooks(String bkID) throws SQLException {
		
		String sql ="Delete from books where bookId = '"+bkID+"'";
		java.sql.Statement  stm = conn.createStatement();
		return stm.executeUpdate(sql)>0;
	}

	@Override
	public boolean updateDelivery(TeaProduct b1) throws SQLException {
		String SQL = "Update books set bookName='"+b1.getBookName()+"',author='"+b1.getBookauthor()+"',category='"+b1.getBookCategory()+"',price='"+b1.getBookPrice()+"' where bookId='"+b1.getBookId()+"' ";
		java.sql.Statement stm = conn.createStatement();
		return stm.executeUpdate(SQL)>0;
	}
	
	
	@Override
	public TeaProduct SearchBooks(String searchBooks) throws Exception {
		String sql = "select * from books where bookName='"+searchBooks+"'";
		System.out.println("gggg:"+sql);
		java.sql.Statement statement = conn.createStatement();
		//Statement statement= conn.createStatement();
		ResultSet rst = statement.executeQuery(sql);
		
		ArrayList<TeaProduct> supList = new ArrayList<TeaProduct>();
		TeaProduct bk = new TeaProduct();
		
		while(rst.next()) {
			
			bk.setBookId(rst.getString("bookId"));
			bk.setBookName(rst.getString("bookName"));
			bk.setBookauthor(rst.getString("author"));
			bk.setBookCategory(rst.getString("category"));
			bk.setBookPrice(Double.parseDouble(rst.getString("price")));
			bk.setPhoto(rst.getString("photo"));
			
		}
		
		return bk;
	}

	
	@Override
	public boolean addNewTea(TeaProduct tea) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}


}




