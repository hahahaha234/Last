package student_Manage;



import javax.management.modelmbean.ModelMBean;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;


public class showtwos {	
	//��ȡѧ����Ϣ��չʾ�ڴ���
		
		ArrayList<Student_information> arry=new ArrayList<Student_information>();
		Student_information stu=new Student_information();
		JTable table = null;
	    DefaultTableModel model = null;
		//��ʾȫ��ѧ����Ϣ
	   public showtwos() {
		    JFrame jf = new JFrame("��ʾ���������Ľ�ʦ��Ϣ(�����ͷ���԰�������������");
		    //jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		    // �����������
		     JPanel panel = new JPanel();
		    // ��ͷ��������
		  //  String[] columnNames ={"���","ѧ��","����","�Ա�","����","�绰����","��ͥסַ","���֤����" };  	
		    Vector columnNames=createColumnNames();	    
		    //��Ҫ��ѯ�ķ���������,���ַ�������f��¼		       
			 String [] f = new String [7];
				try{
					FileReader f1 = new FileReader("��ѯʱ��ʱ��ŵ��ļ�.txt");
					BufferedReader br=new BufferedReader(f1);				
					//arry.clear();//	���ԭ�����б��е�����
					String t=null;
					while ((t= br.readLine())!= null)
						{
						  f=t.split("\\s+");			//Ҫ��ѯ��ѧ����Ϣ	 
						}
					
										
				  f1.close();
				  br.close();				  				  
					} catch (IOException e) {
								// TODO �Զ����ɵ� catch ��
					e.printStackTrace();						
					}
								
				//�ǵ���գ������´β�ѯû��ɸѡ����ʱ����ѯ������һ�ε�����
				 File file =new File("��ѯʱ��ʱ��ŵ��ļ�.txt");
			        try {
			            if(!file.exists()) {
			                file.createNewFile();
			            }
			            FileWriter fileWriter =new FileWriter(file);
			            fileWriter.write("");
			            fileWriter.flush();
			            fileWriter.close();			    		            
			        } catch (IOException e) {
			            e.printStackTrace();			         
			        }		
			    
				//�ж���Ҫ��ѯ������Щ����				
				ArrayList List = new ArrayList(); 
				for(int i=0;i<7;i++) {
					if(!f[i].equals("--"))     //��Ҫ���������
						List.add(i); 							
				}
				//�������ѯ������ѧ����Ϣ¼��ϵͳ				 
				for(int i=0;i<List.size();i++)
					System.out.println(List.get(i));
				try{
						FileReader f1 = new FileReader("teacher.txt");
						BufferedReader br=new BufferedReader(f1);
						String t=null;
						int flag=0;
				        int t1=0;
				        
						arry.clear();//	���ԭ�����б��е�����					
						while ((t= br.readLine())!= null)
							{
							  String [] s=t.split("\\s+");		
							 for(int i=0;i<List.size();i++)
							 {
								 t1=(int) List.get(i);
								 if(f[t1].equals(s[t1])) {
									 flag=flag+1;
								 }
							 }
							  if(flag==List.size()) {
								  Teacher_information te=new Teacher_information(s[0],s[1],s[2],s[3],s[4],s[5],s[6]);//ע�������ļ�ÿ��û���߸��ַ�����������
								 arry.addAll((Collection<? extends Student_information>) te);
							  }							  
							  flag=0;
							  
							}
						     f1.close();
						     br.close();						     						     
							} catch (IOException e) {
									// TODO �Զ����ɵ� catch ��
							e.printStackTrace();				
						}	
		    	 				
				Vector data=createTableModelData();
				
				// ����һ��Ĭ�ϵı��ģ��
			    model = new DefaultTableModel(data, columnNames);
			   table = new JTable(model);
		       table.setPreferredScrollableViewportSize(new Dimension(400, 80));
		       JScrollPane tablePanel = new JScrollPane(table);  
				
				
		        // ���ñ��������ɫ
		        table.setForeground(Color.BLACK);                   // ������ɫ
		        table.setFont(new Font(null, Font.PLAIN, 14));      // ������ʽ
		        table.setSelectionForeground(Color.DARK_GRAY);      // ѡ�к�������ɫ
		        table.setSelectionBackground(Color.LIGHT_GRAY);     // ѡ�к����屳��
		        table.setGridColor(Color.GRAY);                     // ������ɫ

		        // ���ñ�ͷ
		        table.getTableHeader().setFont(new Font(null, Font.BOLD, 14));  // ���ñ�ͷ����������ʽ
		        table.getTableHeader().setForeground(Color.RED);                // ���ñ�ͷ����������ɫ
		        table.getTableHeader().setResizingAllowed(false);               // ���ò������ֶ��ı��п�
		        table.getTableHeader().setReorderingAllowed(false);             // ���ò������϶������������

		        // �����и�
		        table.setRowHeight(40);

		        // ��һ���п�����Ϊ40
		        table.getColumnModel().getColumn(0).setPreferredWidth(40);
	             
		        // ���ù�������ӿڴ�С�������ô�С�������ݣ���Ҫ�϶����������ܿ�����
		        table.setPreferredScrollableViewportSize(new Dimension(900, 320));
		        //������	        
		        RowSorter sorter = new TableRowSorter(model);
		        table.setRowSorter(sorter);
		        JScrollPane pane = new JScrollPane(table);      

		        // �� ��� �ŵ� ������� �У���ͷ���Զ���ӵ�������嶥����
		        JScrollPane scrollPane = new JScrollPane(table);

		        // ��� ������� �� �������
		        panel.add(scrollPane);
		       // JScrollPane pane = new JScrollPane(table);
		        // ���� ������� �� ����
		        jf.setContentPane(panel);
		        jf.pack();
		        jf.setSize(900, 600);
		        jf.add(scrollPane, BorderLayout.CENTER);
		        //���ݾ�����ʾ
		        DefaultTableCellRenderer r = new DefaultTableCellRenderer();   
				r.setHorizontalAlignment(JLabel.CENTER);   
				table.setDefaultRenderer(Object.class, r);
				
				jf.setLocationRelativeTo(null);
				int t=arry.size();
				 //int t=table.getRowCount();
			        if(t<=0){
			        	JOptionPane.showMessageDialog(null, "��ϵͳ��û�з��������Ľ�ʦ������");
			        	jf.setVisible(false);
			        }
			        else {
			        	jf.setVisible(true);
			        }
		    }
     private Vector createColumnNames() {
       Vector columnNames = new Vector();
       //columnNames.add("���");
       columnNames.add("���");
       columnNames.add("����");
       columnNames.add("�Ա�");
       columnNames.add("����");
       columnNames.add("�绰����");
       columnNames.add("��ͥסַ");
       columnNames.add("���֤����");
    
       return columnNames;
       }

     private Vector createTableModelData() {
    	 Vector data = new Vector();    	     	
         for(int i=0;i<arry.size();i++) {       	 
	    	 Vector<String> rowData=new Vector<>();	    	
	    	 rowData.add(arry.get(i).getStuID());
	    	 rowData.add(arry.get(i).getName());
	    	 rowData.add(arry.get(i).getSex());
	    	 rowData.add(arry.get(i).getAge());
	    	 rowData.add(arry.get(i).getCallnumber());
	    	 rowData.add(arry.get(i).getHome_place());
	    	 rowData.add(arry.get(i).getIdentityID());			    	 		    					  
    		 data.add(rowData);
    					  	    							   
		  }	   
         return data;
	  }  
    
}
