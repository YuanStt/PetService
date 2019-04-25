package com.zys.project1.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePetSerFrame extends JFrame {

	public static void main(String[] args) {
		new WelcomePetSerFrame();
	}

	public WelcomePetSerFrame() {

		setTitle("����������ϵͳ");
		setSize(1040, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// �½�һ��Lable
		JLabel lbIcon = new JLabel();
		// �½�һ��ImageIcon
		ImageIcon imageIcon = new ImageIcon("src/dog.jpg");

		Image image = imageIcon.getImage();
		// ��ͼƬ����ѹ�������ݸ����ı������㷨
		Image smallImage = image.getScaledInstance(1040, 600, Image.SCALE_FAST);
		// �����ĵ�ImageIcon
		ImageIcon smImageIcon = new ImageIcon(smallImage);
		// ��ImageIcon���õ�label��
		lbIcon.setIcon(smImageIcon);
		
		JButton btn = new JButton();
		btn.setBounds(50,150,300,100);
		btn.setBorderPainted(false);
		btn.setBorder(null);
		btn.setContentAreaFilled(false);
		ImageIcon icon1 = new ImageIcon("src/welcome.png");
		Image image1 = icon1.getImage();
		Image smallImage1 = image1.getScaledInstance(300, 100, Image.SCALE_FAST);
		ImageIcon smImageIcon1 = new ImageIcon(smallImage1);
		btn.setIcon(smImageIcon1);
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//�رյ�ǰҳ��
				setVisible(false);
				//�򿪹���ҳ��
				new PetSerAddInfo();
				
			}
		});
		
		add(btn);
		add(lbIcon);
		
		setVisible(true);

	}

}
