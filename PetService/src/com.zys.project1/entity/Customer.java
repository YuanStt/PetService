package com.zys.project1.entity;
/*
 * 顾客实体类
 */
public class Customer {

	private int cusid;
	private String cusname;
	private String cusmale;
	private String cusphone;
	private String cusaddress;
	private String ordertime; // 下单时间
	private String charge; // 收费
	private String oddnum; // 服务订单号

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int cusid, String cusname, String cusmale, String cusphone, String cusaddress, String ordertime,
			String charge, String oddnum) {
		super();
		this.cusid = cusid;
		this.cusname = cusname;
		this.cusmale = cusmale;
		this.cusphone = cusphone;
		this.cusaddress = cusaddress;
		this.ordertime = ordertime;
		this.charge = charge;
		this.oddnum = oddnum;
	}

	@Override
	public String toString() {
		return "Customer [cusid=" + cusid + ", cusname=" + cusname + ", cusmale=" + cusmale + ", cusphone=" + cusphone
				+ ", cusaddress=" + cusaddress + ", ordertime=" + ordertime + ", charge=" + charge + ", addnum="
				+ oddnum + "]";
	}

	public int getCusid() {
		return cusid;
	}

	public void setCusid(int cusid) {
		this.cusid = cusid;
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

	public String getOddnum() {
		return oddnum;
	}

	public void setOddnum(String oddnum) {
		this.oddnum = oddnum;
	}

}
