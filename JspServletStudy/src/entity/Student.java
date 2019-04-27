package entity;

public class Student {
	
	//��һ����ĸ���������롰Сд��
	private Integer id;
	private String stuNo;
	private String stuName;
	private String stuBirthday;
	private String stuPhone;
	private String stuAddress;
	private String stuHeight;
	
	//�յĹ��췽��
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//�����ԵĹ��췽��
	public Student(Integer id, String stuNo, String stuName, String stuBirthday, String stuPhone, String stuAddress,
			String stuHeight) {
		super();
		this.id = id;
		this.stuNo = stuNo;
		this.stuName = stuName;
		this.stuBirthday = stuBirthday;
		this.stuPhone = stuPhone;
		this.stuAddress = stuAddress;
		this.stuHeight = stuHeight;
	}
	
	//toString����
	@Override
	public String toString() {
		return "Satudent [id=" + id + ", stuNo=" + stuNo + ", stuName=" + stuName + ", stuBirthday=" + stuBirthday
				+ ", stuPhone=" + stuPhone + ", stuAddress=" + stuAddress + ", stuHeight=" + stuHeight + "]";
	}

	//get/set����
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStuNo() {
		return stuNo;
	}

	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuBirthday() {
		return stuBirthday;
	}

	public void setStuBirthday(String stuBirthday) {
		this.stuBirthday = stuBirthday;
	}

	public String getStuPhone() {
		return stuPhone;
	}

	public void setStuPhone(String stuPhone) {
		this.stuPhone = stuPhone;
	}

	public String getStuAddress() {
		return stuAddress;
	}

	public void setStuAddress(String stuAddress) {
		this.stuAddress = stuAddress;
	}

	public String getStuHeight() {
		return stuHeight;
	}

	public void setStuHeight(String stuHeight) {
		this.stuHeight = stuHeight;
	}
	
	

}
