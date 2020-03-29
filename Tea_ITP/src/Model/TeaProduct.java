package Model;

public class TeaProduct {
	
	private String teaId;
	private String teaCode;
	private String teaName;
	private String teaCategory;
	private double teaPrice;
	private String teaStatus;
	private String teaDescrip;
	private double teaWeight;
	private String photo;
	
	
	public TeaProduct() {
		// TODO Auto-generated constructor stub
	}

	public TeaProduct(String teaId, String teaCode, String teaName, String teaCategory, double teaPrice,
			String teaStatus, String teaDescrip, String photo, double teaWeight) {
		super();
		this.teaId = teaId;
		this.teaCode = teaCode;
		this.teaName = teaName;
		this.teaCategory = teaCategory;
		this.teaPrice = teaPrice;
		this.teaStatus = teaStatus;
		this.teaDescrip = teaDescrip;
		this.photo = photo;
		this.teaWeight = teaWeight;
	}

	public String getTeaId() {
		return teaId;
	}

	public void setTeaId(String teaId) {
		this.teaId = teaId;
	}

	public String getTeaCode() {
		return teaCode;
	}

	public void setTeaCode(String teaCode) {
		this.teaCode = teaCode;
	}

	public String getTeaName() {
		return teaName;
	}

	public void setTeaName(String teaName) {
		this.teaName = teaName;
	}

	public String getTeaCategory() {
		return teaCategory;
	}

	public void setTeaCategory(String teaCategory) {
		this.teaCategory = teaCategory;
	}

	public double getTeaPrice() {
		return teaPrice;
	}

	public void setTeaPrice(double teaPrice) {
		this.teaPrice = teaPrice;
	}

	public String getTeaStatus() {
		return teaStatus;
	}

	public void setTeaStatus(String teaStatus) {
		this.teaStatus = teaStatus;
	}

	public String getTeaDescrip() {
		return teaDescrip;
	}

	public void setTeaDescrip(String teaDescrip) {
		this.teaDescrip = teaDescrip;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public double getTeaWeight() {
		return teaWeight;
	}

	public void setTeaWeight(double teaWeight) {
		this.teaWeight = teaWeight;
	}
	
	
}
