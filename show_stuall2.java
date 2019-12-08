package student_Manage;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import java.io.*;

import java.util.ArrayList;
import java.util.Vector;

//��ȡѧ����Ϣ��չʾ�ڴ���

public class show_stuall2 {	
	
	JTable table = null;
    DefaultTableModel model = null;
	//��ʾȫ��ѧ����Ϣ
   public show_stuall2() {
	    JFrame jf = new JFrame("��ʾȫ����Ϣ(�����ͷ���԰�������������)");	   
	    // �����������
	     JPanel panel = new JPanel();
	    // ��ͷ��������
	   Vector tcolumnNames=createColumnNames();
	   Vector tdata=createTableModelData();	   
	 // ����һ��Ĭ�ϵı��ģ��
	    model = new DefaultTableModel(tdata, tcolumnNames);
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
	        int t=table.getRowCount();
	        if(t<=0){
	        	JOptionPane.showMessageDialog(null, "��ϵͳ�л�û��¼��ѧ����Ϣ������");
	        	jf.setVisible(false);
	        }
	        else {
	        	jf.setVisible(true);
	        }	 
	    }
    
     private Vector createColumnNames() {
       Vector columnNames = new Vector();
       //columnNames.add("���");
       columnNames.add("��ź�");
       columnNames.add("����");
       columnNames.add("�Ա�");
       columnNames.add("����");
       columnNames.add("�绰����");
       columnNames.add("���̿γ�");
       columnNames.add("���֤����");
       
       return columnNames;
   }
   
     private Vector createTableModelData() {
        
         Vector data = new Vector();
         String t=null;
			try{
				FileReader f1 = new FileReader("teacher.txt");
				BufferedReader br=new BufferedReader(f1);				
				//arry.clear();//	���ԭ�����б��е�����
				int i=0;
				while ((t= br.readLine())!= null)
					{
					  String [] s=t.split("\\s+");		//ͨ���ո�ָ��ַ�������					  
					  Vector rowData = new Vector();
				
					  //rowData.add("i");				  
					  rowData.add(s[0]);					  
					  rowData.add(s[1]);
					  rowData.add(s[2]);
					  rowData.add(s[3]);
					  rowData.add(s[4]);			  
					  rowData.add(s[5]);   
					  rowData.add(s[6]);				  
					  data.add(rowData);					  
					 // System.out.print(s[6]);					  
					  i++;					   
					}
				     f1.close();
				     br.close();			     
				     
					} catch (IOException e) {
							// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
					
				}	  
        return data;
     }   
}
