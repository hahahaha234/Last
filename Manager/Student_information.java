package student_Manage;

public class Student_information {
	private String stuID;    /*  ѧ��ѧ��  */
	private String name;     /* ѧ������ */
	private String sex;     /* ѧ���Ա�  */
    private String age;        /*  ѧ������  */
    private String callnumber;   /* ѧ���绰����   */
    private String home_place;   /* ѧ����ͥסַ������ */
    private String identityID;   /* ѧ�����֤���� */
    
    /*�޲ι��캯��*/
    public Student_information() {
    
    }
    /*�вι��캯�� */
    public Student_information(String stuID,String name,String sex,String age,String callnumber,String home_place,String identityID) {
    	super();
    	this.stuID=stuID;
    	this.name=name;
    	this.sex=sex;
    	this.age=age;
    	this.callnumber=callnumber;
    	this.home_place=home_place;
    	this.identityID=identityID;
    }
    public String getStuID() {
    	return this.stuID;
    }
    public void setStuID(String stuID) {
    	this.stuID=stuID;
    }
    
    public String getName() {
    	return name;
    }
    public void setName(String name) {
    	this.name=name;
    }
    
    public String getSex() {
    	return this.sex;
    }
    public void setSex(String sex) {
    	this.sex=sex;
    }
    
    public String getAge() {
    	return this.age;
    }
    public void setAge(String age) {
    	this.age=age;
    }
    
    public String getCallnumber() {
    	return this.callnumber;
    }
    public void setCallnummber(String callnumber) {
    	this.callnumber=callnumber;
    }
    
    public String getHome_place() {
    	return this.home_place;
    }
    public void setHome_place(String home_place) {
    	this.home_place=home_place;
    }
    
    public String getIdentityID() {
    	return this.identityID;
    }
    public void setIdentityID(String identityID) {
    	this.identityID=identityID;
    }
    
    //���ļ���¼������ݸ�ʽ    "ѧ��  ����  �Ա�  ����  �绰����  ��ͥסַ  ���֤����"  
    public String fileString()
	{
		return stuID+" "+name+" "+sex+" "+age+"  "+callnumber+"  "+home_place+"  "+identityID;
	}

   
}

