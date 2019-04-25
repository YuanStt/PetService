package com.zys.project1.entity;

/*
 * ����ʵ����
 */
public class Pet {

	private int petid;
	private String petkind;			//��������
	private String petname;
	private String cusname;			//������������
	private String serviceitem;		//������Ŀ
	private String oddnum;			//���񵥺�

	public Pet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Pet [petid=" + petid + ", petkind=" + petkind + ", petname=" + petname + ", cusname=" + cusname
				+ ", serviceitem=" + serviceitem + ", oddnum=" + oddnum + "]";
	}

	public Pet(int petid, String petkind, String petname, String cusname, String serviceitem, String oddnum) {
		super();
		this.petid = petid;
		this.petkind = petkind;
		this.petname = petname;
		this.cusname = cusname;
		this.serviceitem = serviceitem;
		this.oddnum = oddnum;
	}

	public int getPetid() {
		return petid;
	}

	public void setPetid(int petid) {
		this.petid = petid;
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

	public String getCusname() {
		return cusname;
	}

	public void setCusname(String cusname) {
		this.cusname = cusname;
	}

	public String getServiceitem() {
		return serviceitem;
	}

	public void setServiceitem(String serviceitem) {
		this.serviceitem = serviceitem;
	}

	public String getOddnum() {
		return oddnum;
	}

	public void setOddnum(String oddnum) {
		this.oddnum = oddnum;
	}

}
