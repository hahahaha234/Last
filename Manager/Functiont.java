package student_Manage;



import java.io.*;
import java.util.*;


//修改，删除，增加某个学生信息

class Functiont {
	
	//本程序学生数量不多，用数组列表ArrayList,  当学生数据多的时候，考虑用链表
    ArrayList<Teacher_information> arry=new ArrayList<Teacher_information>();  			
	public Functiont()           //读文件，将文件中的学生信息存放在数组列表
	{
		this.readfile();
	}
	//根据学号查找学生信息，找到返回学号，找不到返回-1
	public int find(String str) 
	{		
	    for (int i = 0; i<arry.size(); i++)
	      if (arry.get(i).getteaID().equals(str))
						return i;//等于在数组列表的位置
			return -1;
	}	
	
	//修改学生信息
	public void update(Teacher_information tea) {
		int flag=find(tea.getteaID());    //查找是否存在
		arry.set(flag, tea);		   //替换 flag 处的学生信息
	}	
	// 读文件，
	public boolean readfile() {					 
			String t=null;
			try{
				FileReader f1 = new FileReader("teacher.txt");
				BufferedReader br=new BufferedReader(f1);				
				arry.clear();    //	清除原数组列表中的数据				
				while ((t= br.readLine())!= null)
					{
					  String [] s=t.split("\\s+");				 
					  Teacher_information te=Teacher_information(s[0],s[1],s[2],s[3],s[4],s[5],s[6]);//注意若该文件每行没有七个字符串，则会出错
					  arry.add(te);
					  System.out.println("读取文件：");
					  System.out.println(s[0]);
					}
				     f1.close();
				     br.close();				     
				     return true;
					} catch (IOException e) {
							// TODO 自动生成的 catch 块
					e.printStackTrace();
					return false;
				}	
		     }					
	private Teacher_information Teacher_information(String string, String string2, String string3, String string4,
			String string5, String string6, String string7) {
		// TODO 自动生成的方法存根
		return null;
	}
	//添加学生信息	
	public boolean add(Teacher_information tea)
	     {		
		System.out.println();	
		System.out.println("要添加的教师");	
		System.out.println(tea.fileString());
		System.out.println();
		if (find(tea.getteaID())!=-1)
			return false;		
		arry.add( tea); 
		return true;			
	}
	
	//写注意每行必须有七个元素，否则读取文件并判断是否存在时会出错时会出错，没有输入的用---代替
	public boolean writefile() {
				FileWriter fw=null;
				BufferedWriter out=null;
				try {
					 fw = new FileWriter("teacher.txt");    
					 out = new BufferedWriter(fw);
					 //姓名学号等中间隔一个空格
						for(int i=0;i<arry.size();i++){
							String s=arry.get(i).fileString();
							System.out.println("数组列表数据：");
							System.out.println(arry.get(i).fileString());
					    	out.write(s);
					    	out.newLine();
					    }
						out.close();
						fw.close();
						return true;
				} catch (IOException e) {
					e.printStackTrace();
					return false;
				}
		   }
	
	//删除学生信息,并且文件中的内容也要修改
	public boolean delete(String s)	//添加学生记信息
	{  
		int pos=find(s);
		if (pos==-1)
			return false;
		
		arry.remove(pos);    
		return true;
	}
	
		
/*
	//删除学生信息，并且重写文件内容					
	 public boolean delete(String s) {	
		        File file =new File("student.txt");
		        try {
		            if(!file.exists()) {
		                file.createNewFile();
		            }
		            FileWriter fileWriter =new FileWriter(file);
		            fileWriter.write("");
		            fileWriter.flush();
		            fileWriter.close();		            
	    			int flag=find(s);		    		
		    		System.out.print(flag);
		    		arry.remove(flag);  		    		
		    		writefile();
		    		return true;	            
		        } catch (IOException e) {
		            e.printStackTrace();
		            return false;
		        }				
		    }
		    */		
}
