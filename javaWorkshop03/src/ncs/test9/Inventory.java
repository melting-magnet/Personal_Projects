package ncs.test9;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Inventory {

//	- productName:String //상품명
//	- putDate:Date //입고일
//	- getDate:Date //출고일
//	- putAmount:int //입고수량
//	- getAmount:int //출고수량
//	- inventoryAmount:int //재고수량

	private String productName;
	private Date putDate;
	private Date getDate;
	private int putAmount;
	private int getAmount;
	private int inventoryAmount;

	public Inventory() {

	}

	public Inventory(String productName, Date putDate, Date getDate, int putAmount, int getAmount,
			int inventoryAmount) {
		super();
		this.productName = productName;
		this.putDate = putDate;
		this.getDate = getDate;
		this.putAmount = putAmount;
		this.getAmount = getAmount;
		this.inventoryAmount = inventoryAmount;
	}

	@Override
	public String toString() {
		
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 M월 d일");
	    String formattedPutDate = (putDate != null) ? dateFormat.format(putDate) : "null";
	    String formattedGetDate = (getDate != null) ? dateFormat.format(getDate) : "null";

	    return productName + ", " + formattedPutDate + " 입고, " + putAmount + "개, " +
	            formattedGetDate + " 출고, " + getAmount + "개, 재고 " + inventoryAmount + "개";
	}
	
	public void setGetDate(Date setDate) {
		
	    this.getDate = setDate;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Date getPutDate() {
		return putDate;
	}

	public void setPutDate(Date putDate) {
		this.putDate = putDate;
	}

	public int getPutAmount() {
		return putAmount;
	}

	public void setPutAmount(int putAmount) {
		this.putAmount = putAmount;
	}

	public int getGetAmount() {
		return getAmount;
	}

	public void setGetAmount(int getAmount) {
		this.getAmount = getAmount;
	}

	public int getInventoryAmount() {
		return inventoryAmount;
	}

	public void setInventoryAmount(int inventoryAmount) {
		this.inventoryAmount = inventoryAmount;
	}

	public Date getGetDate() {
		return getDate;
	}
	
	

}
