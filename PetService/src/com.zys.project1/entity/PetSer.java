package com.zys.project1.entity;

public class PetSer {

	private String oddnum;
	private String serviceitem;
	private String cusname;
	private String cusmale;
	private String cusphone;
	private String cusaddress;
	private String ordertime;
	private String charge;
	private String petkind;
	private String petname;

	public PetSer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PetSer(String oddnum, String serviceitem, String cusname, String cusmale, String cusphone, String cusaddress,
			String ordertime, String charge, String petkind, String petname) {
		super();
		this.oddnum = oddnum;
		this.serviceitem = serviceitem;
		this.cusname = cusname;
		this.cusmale = cusmale;
		this.cusphone = cusphone;
		this.cusaddress = cusaddress;
		this.ordertime = ordertime;
		this.charge = charge;
		this.petkind = petkind;
		this.petname = petname;
	}

	@Override
	public String toString() {
		return "PetSer [oddnum=" + oddnum + ", serviceitem=" + serviceitem + ", cusname=" + cusname + ", cusmale="
				+ cusmale + ", cusphone=" + cusphone + ", cusaddress=" + cusaddress + ", ordertime=" + ordertime
				+ ", charge=" + charge + ", petkind=" + petkind + ", petname=" + petname + "]";
	}

	public String getOddnum() {
		return oddnum;
	}

	public void setOddnum(String oddnum) {
		this.oddnum = oddnum;
	}

	public String getServiceitem() {
		return serviceitem;
	}

	public void setServiceitem(String serviceitem) {
		this.serviceitem = serviceitem;
	}

	public String getCusname() {
		return cusname;
	}

	public void setCusname(String cusname) {
		this.cusname = cusname;
	}

	public String getCusmale() {
		return cusmale;
	}

	public void setCusmale(String cusmale) {
		this.cusmale = cusmale;
	}

	public String getCusphone() {
		return cusphone;
	}

	public void setCusphone(String cusphone) {
		this.cusphone = cusphone;
	}

	public String getCusaddress() {
		return cusaddress;
	}

	public void setCusaddress(String cusaddress) {
		this.cusaddress = cusaddress;
	}

	public String getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}

	public String getCharge() {
		return charge;
	}

	public void setCharge(String charge) {
		this.charge = charge;
	}

	public String getPetkind() {
		return petkind;
	}

	public void setPetkind(String petkind) {
		this.petkind = petkind;
	}

	public String getPetname() {
		return petname;
	}

	public void setPetname(String petname) {
		this.petname = petname;
	}

}
