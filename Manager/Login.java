package student_Manage;

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

public  class Login extends JFrame implements  ActionListener{
	//�������
	JFrame frame=new JFrame();
	JPanel jp1,jp2,jp3;//���
	JLabel jlb1,jlb2;//��ǩ
	JButton jb1,jb2;//��ť
	
	//���캯��
	public Login(){
		//�������
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		
		//������ǩ
		jlb1=new JLabel("�밴��������ѡ���½");
		
		//������ť
		jb1=new JButton("ѧ��");
		jb2=new JButton("��ʦ");

		//���ò��ֹ���
		frame.setLayout(new GridLayout(4, 1));//����ʽ����
		
		//����������
		jp1.add(jlb1);
			
		jp3.add(jb1);
		jp3.add(jb2);
		
		
		//���뵽JFrame
		frame.add(jp2);
		frame.add(jp1);
		//this.add(jp2);
		frame.add(jp3);
		
		//���ô���
		frame.setTitle("�û���¼����");//�����ǩ
		frame.setSize(400, 300);//�����С
		frame.setLocationRelativeTo(null);//����Ļ�м���ʾ(������ʾ)
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�˳��ر�JFrame
		frame.setVisible(true);//��ʾ����
		
		//��������
		//this.setResizable(false);
				
		jb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   frame.setVisible(false);
				new ManagerLogin();
			}
		});
		
		jb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   frame.setVisible(false);
				new TeacherLogin();
			}
		});
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

