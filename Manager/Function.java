package student_Manage;

import java.io.*;
import java.util.*;


//�޸ģ�ɾ��������ĳ��ѧ����Ϣ

class Function {
	
	//������ѧ���������࣬�������б�ArrayList,  ��ѧ�����ݶ��ʱ�򣬿���������
    ArrayList<Student_information> arry=new ArrayList<Student_information>();  			
	public Function()           //���ļ������ļ��е�ѧ����Ϣ����������б�
	{
		this.readfile();
	}
	//����ѧ�Ų���ѧ����Ϣ���ҵ�����ѧ�ţ��Ҳ�������-1
	public int find(String str) 
	{		
	    for (int i = 0; i<arry.size(); i++)
	      if (arry.get(i).getStuID().equals(str))
						return i;//�����������б��λ��
			return -1;
	}	
	
	//�޸�ѧ����Ϣ
	public void update(Student_information stu) {
		int flag=find(stu.getStuID());    //�����Ƿ����
		arry.set(flag, stu);		   //�滻 flag ����ѧ����Ϣ
	}	
	// ���ļ���
	public boolean readfile() {					 
			String t=null;
			try{
				FileReader f1 = new FileReader("student.txt");
				BufferedReader br=new BufferedReader(f1);				
				arry.clear();    //	���ԭ�����б��е�����				
				while ((t= br.readLine())!= null)
					{
					  String [] s=t.split("\\s+");				 
					  Student_information st=new Student_information(s[0],s[1],s[2],s[3],s[4],s[5],s[6]);//ע�������ļ�ÿ��û���߸��ַ�����������
					  arry.add(st);
					  System.out.println("��ȡ�ļ���");
					  System.out.println(s[0]);
					}
				     f1.close();
				     br.close();				     
				     return true;
					} catch (IOException e) {
							// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
					return false;
				}	
		     }					
	//���ѧ����Ϣ	
	public boolean add(Student_information stu)
	     {		
		System.out.println();	
		System.out.println("Ҫ��ӵ�ѧ��");	
		System.out.println(stu.fileString());
		System.out.println();
		if (find(stu.getStuID())!=-1)
			return false;		
		arry.add(stu); 
		return true;			
	}
	
	//дע��ÿ�б������߸�Ԫ�أ������ȡ�ļ����ж��Ƿ����ʱ�����ʱ�����û���������---����
	public boolean writefile() {
				FileWriter fw=null;
				BufferedWriter out=null;
				try {
					 fw = new FileWriter("student.txt");    
					 out = new BufferedWriter(fw);
					 //����ѧ�ŵ��м��һ���ո�
						for(int i=0;i<arry.size();i++){
							String s=arry.get(i).fileString();
							System.out.println("�����б����ݣ�");
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
	
	//ɾ��ѧ����Ϣ,�����ļ��е�����ҲҪ�޸�
	public boolean delete(String s)	//���ѧ������Ϣ
	{  
		int pos=find(s);
		if (pos==-1)
			return false;
		
		arry.remove(pos);    
		return true;
	}
	
		
/*
	//ɾ��ѧ����Ϣ��������д�ļ�����					
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
