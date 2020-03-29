package Services;

import java.sql.SQLException;
import java.util.ArrayList;

import Model.TeaProduct;

public interface TeaProductService {

	
	
	
	
	public ArrayList<TeaProduct> getAllBooksNovel() throws SQLException;
	
	public ArrayList<TeaProduct> getAllBooksChildren() throws SQLException;
	
	public ArrayList<TeaProduct> getAllBooksEducation() throws SQLException;
	
	public ArrayList<TeaProduct> getAllBooksindex() throws SQLException;
	
	public ArrayList<TeaProduct> getAllBooksindex2() throws SQLException;

	boolean deleteBooks(String bkID) throws SQLException;

	boolean updateDelivery(TeaProduct b1) throws SQLException ;
	
	TeaProduct SearcTeas(String searchTeas) throws Exception;

	boolean addNewTea(TeaProduct tea)throws SQLException;

	ArrayList<TeaProduct> getAllTeaProduts() throws SQLException;

	boolean addNewTeaProduct(TeaProduct tea) throws SQLException;

	public TeaProduct SearchTeas(String name);

	

	

	

}
