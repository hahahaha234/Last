package student_Manage;

public class Teacher_information {
	private String teaID;    /*  学生学号  */
	private String tname;     /* 学生姓名 */
	private String tsex;     /* 学生性别  */
    private String tage;        /*  学生年龄  */
    private String tcallnumber;   /* 学生电话号码   */
    private String tcourse;   /* 学生家庭住址，籍贯 */
    private String tidentityID;   /* 学生身份证号码 */
    
    /*无参构造函数*/
    public Teacher_information() {
    
    }
    /*有参构造函数 */
    public Teacher_information(String teaID,String tname,String tsex,String tage,String tcallnumber,String tcourse,String tidentityID) {
    	super();
    	this.teaID=teaID;
    	this.tname=tname;
    	this.tsex=tsex;
    	this.tage=tage;
    	this.tcallnumber=tcallnumber;
    	this.tcourse=tcourse;
    	this.tidentityID=tidentityID;
    }
    public String getteaID() {
    	return this.teaID;
    }
    public void setteaID(String teaID) {
    	this.teaID=teaID;
    }
    
    public String gettName() {
    	return tname;
    }
    public void settName(String tname) {
    	this.tname=tname;
    }
    
    public String gettSex() {
    	return this.tsex;
    }
    public void settSex(String tsex) {
    	this.tsex=tsex;
    }
    
    public String gettAge() {
    	return this.tage;
    }
    public void settAge(String tage) {
    	this.tage=tage;
    }
    
    public String gettCallnumber() {
    	return this.tcallnumber;
    }
    public void settCallnummber(String tcallnumber) {
    	this.tcallnumber=tcallnumber;
    }
    
    public String gettcourse() {
    	return this.tcourse;
    }
    public void settcourse(String tcourse) {
    	this.tcourse=tcourse;
    }
    
    public String gettIdentityID() {
    	return this.tidentityID;
    }
    public void settIdentityID(String tidentityID) {
    	this.tidentityID=tidentityID;
    }
    
    //从文件中录入的数据格式    "学号  姓名  性别  年龄  电话号码  家庭住址  身份证号码"  
    public String fileString()
	{
		return teaID+" "+tname+" "+tsex+" "+tage+"  "+tcallnumber+"  "+tcourse+"  "+tidentityID;
	}

   
}

