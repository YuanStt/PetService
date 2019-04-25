package com.zys.project1.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.zys.project1.entity.PetSer;
import com.zys.project1.service.PetSerService;
import com.zys.project1.service.impl.PetSerServiceImpl;

public class PetSerAddInfo extends JFrame {

	private JScrollPane jScrollPane;
	private JButton next, previous, first, last, query, btnadd;
	private JButton modifyBtn, deleteBtn, exportExcelBtn, backBtn;

	private JLabel oddnum;
	private JLabel serviceitem;
	private JLabel cusname;
	private JLabel cusmale;
	private JLabel cusphone;
	private JLabel cusaddress;
	private JLabel ordertime;
	private JLabel charge;
	private JLabel petkind;
	private JLabel petname;
	private JTextField petseroddnum;
	private JTextField petserserviceitem;
	private JTextField petsercusname;
	private JTextField petsercusmale;
	private JTextField petsercusphone;
	private JTextField petsercusaddress;
	private JTextField petserordertime;
	private JTextField petsercharge;
	private JTextField petserpetkind;
	private JTextField petserpetname;
	private JLabel label1, label2; // 1.��ʾ��ҳ���͵�ǰҳ�� 2.ÿҳ��ʾ��

	private JTable tblData;

	private Object[][] dataObject;

	private List<PetSer> list;

	private int rowNum = -1;

	private int page = 1;

	private PetSerService petSerService;

	public static void main(String[] args) {

		new PetSerAddInfo();

	}

	public PetSerAddInfo() {

		setTitle("��ӷ�����Ϣ");
		setSize(1040, 680);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// ���ñ��ı���
		String[] columuNames = { "������", "������Ŀ", "�˿�����", "�˿��Ա�", "�˿͵绰", "��ͥ��ַ", "�µ�ʱ��", "���ѽ��", "�������", "��������" };

		String[] array = { "10", "20", "30", "40", "50" };
		JComboBox box = new JComboBox(array);

		// ��ȡ���ݿ��е�����
		petSerService = new PetSerServiceImpl();
		DefaultTableModel defaultTableModel = refreshTableData(columuNames, petSerService);

		tblData = new JTable(defaultTableModel);

		// ���ñ��������ɫ
		tblData.setForeground(Color.BLACK); // ������ɫ
		tblData.setFont(new Font(null, Font.PLAIN, 14)); // ������ʽ
		tblData.setSelectionForeground(Color.DARK_GRAY); // ѡ�к�������ɫ
		tblData.setSelectionBackground(Color.LIGHT_GRAY); // ѡ�к����屳��
		tblData.setGridColor(Color.GRAY); // ������ɫ

		// ���ñ�ͷ
		tblData.getTableHeader().setFont(new Font(null, Font.BOLD, 14)); // ���ñ�ͷ����������ʽ
		tblData.getTableHeader().setForeground(Color.BLACK); // ���ñ�ͷ����������ɫ
		tblData.getTableHeader().setResizingAllowed(false); // ���ò������ֶ��ı��п�
		tblData.getTableHeader().setReorderingAllowed(false); // ���ò������϶������������

		// �����и�
		tblData.setRowHeight(30);

		// ��һ���п�����Ϊ40
		tblData.getColumnModel().getColumn(0).setPreferredWidth(40);

		tblData.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {

				// System.out.println("�������");
				// ������˫��
				if (e.getClickCount() == 2) {
					System.out.println("���˫����");
					// ��ȡ˫������������
					rowNum = tblData.rowAtPoint(e.getPoint());
					System.out.println("˫���ˣ��±�Ϊ" + (rowNum + 1) + "������");
					// ͨ���±��õ�����
					System.out.println("����Ϊ��" + dataObject[rowNum][2]);
					PetSer p = list.get(rowNum);
					petseroddnum.setText(p.getOddnum());
					petserserviceitem.setText(p.getServiceitem());
					petsercusname.setText(p.getCusname());
					petsercusmale.setText(p.getCusmale());
					petsercusphone.setText(p.getCusphone());
					petsercusaddress.setText(p.getCusaddress());
					petsercharge.setText(p.getCharge());
					petserordertime.setText(p.getOrdertime());
					petserpetkind.setText(p.getPetkind());
					petserpetname.setText(p.getPetname());

				}

			}
		});

		Font font = new Font("����", Font.CENTER_BASELINE, 14);

		oddnum = new JLabel("������");
		oddnum.setBounds(40, 30, 70, 30);
		oddnum.setFont(font);

		petseroddnum = new JTextField();
		petseroddnum.setBounds(100, 30, 100, 30);

		serviceitem = new JLabel("������Ŀ");
		serviceitem.setBounds(210, 30, 70, 30);
		serviceitem.setFont(font);

		petserserviceitem = new JTextField();
		petserserviceitem.setBounds(280, 30, 100, 30);

		cusname = new JLabel("�˿�����");
		cusname.setBounds(40, 65, 60, 30);
		cusname.setFont(font);

		petsercusname = new JTextField();
		petsercusname.setBounds(100, 65, 100, 30);

		cusmale = new JLabel("�˿��Ա�");
		cusmale.setBounds(210, 65, 70, 30);
		cusmale.setFont(font);

		petsercusmale = new JTextField();
		petsercusmale.setBounds(280, 65, 100, 30);

		cusphone = new JLabel("�˿͵绰");
		cusphone.setBounds(390, 30, 70, 30);
		cusphone.setFont(font);

		petsercusphone = new JTextField();
		petsercusphone.setBounds(460, 30, 100, 30);

		cusaddress = new JLabel("�˿͵�ַ");
		cusaddress.setBounds(390, 65, 70, 30);
		cusaddress.setFont(font);

		petsercusaddress = new JTextField();
		petsercusaddress.setBounds(460, 65, 100, 30);

		ordertime = new JLabel("�µ�ʱ��");
		ordertime.setBounds(570, 30, 70, 30);
		ordertime.setFont(font);

		petserordertime = new JTextField();
		petserordertime.setBounds(640, 30, 100, 30);

		charge = new JLabel("���ѽ��");
		charge.setBounds(570, 65, 70, 30);
		charge.setFont(font);

		petsercharge = new JTextField();
		petsercharge.setBounds(640, 65, 100, 30);

		petkind = new JLabel("��������");
		petkind.setBounds(750, 30, 70, 30);
		petkind.setFont(font);

		petserpetkind = new JTextField();
		petserpetkind.setBounds(820, 30, 100, 30);

		petname = new JLabel("��������");
		petname.setBounds(750, 65, 70, 30);
		petname.setFont(font);

		petserpetname = new JTextField();
		petserpetname.setBounds(820, 65, 100, 30);

		query = new JButton("��ѯ");
		query.setBounds(925, 65, 90, 30);
		// query.setFont(font);
		query.setForeground(Color.blue);
		ImageIcon icon1 = new ImageIcon("src/com/zys/project1/images/icons/query1.png");
		query.setIcon(icon1);

		query.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String odd = petseroddnum.getText();
				String cname = petsercusname.getText();
				if (!"".equals(odd)) {
					list = petSerService.findPetSerByOdd(odd);
					DefaultTableModel defaultTableModel = refreshTableData1(columuNames);
					tblData.setModel(defaultTableModel);
					// ����UI
					tblData.updateUI();
					page++;
				} else if (!"".equals(cname)) {
					list = petSerService.findPetSerByName(cname);
					DefaultTableModel defaultTableModel = refreshTableData1(columuNames);
					tblData.setModel(defaultTableModel);
					// ����UI
					tblData.updateUI();
					page++;
				} else {
					// ʧ��
					JOptionPane.showMessageDialog(null, "����ʧ�ܣ�");
				}

			}

		});

		btnadd = new JButton("���");
		btnadd.setBounds(925, 30, 90, 30);
		// query.setFont(font);
		btnadd.setForeground(Color.blue);
		ImageIcon icon2 = new ImageIcon("src/com/zys/project1/images/icons/add.png");
		btnadd.setIcon(icon2);

		// ��Ӱ�ť�İ�ť����
		btnadd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// ����ѧ����Ϣ
				// 1.�õ�������ѧ����Ϣ
				String odd = petseroddnum.getText();
				String ser = petserserviceitem.getText();
				String cname = petsercusname.getText();
				String cmale = petsercusmale.getText();
				String cphone = petsercusphone.getText();
				String caddresss = petsercusaddress.getText();
				String order = petserordertime.getText();
				String scharge = petsercharge.getText();
				String pkind = petserpetkind.getText();
				String pname = petserpetname.getText();
				// ����Ҫ��У��
				if ((!"".equals(odd)) && (!"".equals(cname)) && (!"".equals(ser))) {
					// ִ�����ݿ����
					// ʵ��һ��Student����
					PetSer ps = new PetSer();
					ps.setOddnum(odd);
					ps.setServiceitem(ser);
					ps.setCusname(cname);
					ps.setCusmale(cmale);
					ps.setCusphone(cphone);
					ps.setCusaddress(caddresss);
					ps.setOrdertime(order);
					ps.setCharge(scharge);
					ps.setPetkind(pkind);
					ps.setPetname(pname);
					// PetSerService����ɲ������
					PetSerService petSerService = new PetSerServiceImpl();
					boolean isOk = petSerService.save(ps);
					if (isOk) {
						list = petSerService.findAll();
						DefaultTableModel defaultTableModel = refreshTableData1(columuNames);
						// ��������table�е�ģ��
						tblData.setModel(defaultTableModel);
						// ����UI
						tblData.updateUI();
						clearUpTxt();
					} else {
						// ʧ��
						JOptionPane.showMessageDialog(null, "����ʧ�ܣ�");
					}

				}
			}
		});
		
		
		box.setBounds(890, 105, 100, 20);
		
		label2 = new JLabel("ÿҳ��ʾ����:");
		label2.setBounds(800, 93, 120, 50);
		jScrollPane = new JScrollPane();// ���ù�����
		jScrollPane.setViewportView(tblData);
		jScrollPane.setBounds(42, 136, 950, 420);
		jScrollPane.setOpaque(false);
		jScrollPane.getViewport().setOpaque(false);
		// �߿���ʽб��߿򣨰���
		jScrollPane.setBorder(BorderFactory.createLoweredBevelBorder());

		first = new JButton("��һҳ");
		first.setBounds(44, 570, 90, 30);

		first.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int pageSize = Integer.parseInt((String) box.getSelectedItem());
				if (page == 1) {
					JOptionPane.showMessageDialog(null, "��ǰ���ڵ�һҳ��");
				} else {
					int firstpage = 1;
					list = petSerService.findAllByPage(pageSize, firstpage);
					DefaultTableModel defaultTableModel = refreshTableData1(columuNames);
					// ��������table�е�ģ��
					tblData.setModel(defaultTableModel);
					// ����UI
					tblData.updateUI();
					page = 1;
				}

			}
		});

		previous = new JButton("��һҳ");
		previous.setBounds(164, 570, 90, 30);

		previous.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int pageSize = Integer.parseInt((String) box.getSelectedItem());
				if (page == 1) {
					JOptionPane.showMessageDialog(null, "��ǰ���ڵ�һҳ��");
				} else {
					list = petSerService.findAllByPage(pageSize, page - 1);
					DefaultTableModel defaultTableModel = refreshTableData1(columuNames);
					// ��������table�е�ģ��
					tblData.setModel(defaultTableModel);
					// ����UI
					tblData.updateUI();
					page--;
				}

			}
		});

		next = new JButton("��һҳ");
		next.setBounds(284, 570, 90, 30);

		next.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int pageSize = Integer.parseInt((String) box.getSelectedItem());
				list = petSerService.findAllByPage(pageSize, page + 1);
				if (list.size() != 0) {
					DefaultTableModel defaultTableModel = refreshTableData1(columuNames);
					// ��������table�е�ģ��
					tblData.setModel(defaultTableModel);
					// ����UI
					tblData.updateUI();
					page++;
				} else {
					JOptionPane.showMessageDialog(null, "��ǰ�������һҳ��");
				}

			}
		});

		last = new JButton("��ҳ");
		last.setBounds(404, 570, 90, 30);

		last.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int pageSize = Integer.parseInt((String) box.getSelectedItem());
				list = petSerService.findAllByPage(pageSize, page);
				DefaultTableModel defaultTableModel = refreshTableData1(columuNames);
				// ��������table�е�ģ��
				tblData.setModel(defaultTableModel);
				// ����UI
				tblData.updateUI();

			}
		});

		modifyBtn = new JButton("�޸�");
		modifyBtn.setBounds(524, 570, 90, 30);

		modifyBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (rowNum > -1) {
					System.out.println("ѡ���˼�¼");
					PetSer ps = list.get(rowNum);
					String odd = petseroddnum.getText();
					String ser = petserserviceitem.getText();
					String cname = petsercusname.getText();
					String cmale = petsercusmale.getText();
					String cphone = petsercusphone.getText();
					String caddresss = petsercusaddress.getText();
					String order = petserordertime.getText();
					String scharge = petsercharge.getText();
					String pkind = petserpetkind.getText();
					String pname = petserpetname.getText();
					if ((!"".equals(odd)) && (!"".equals(cname))) {
						// �����޸�
						ps.setOddnum(odd);
						ps.setServiceitem(ser);
						ps.setCusname(cname);
						ps.setCusmale(cmale);
						ps.setCusphone(cphone);
						ps.setCusaddress(caddresss);
						ps.setOrdertime(order);
						ps.setCharge(scharge);
						ps.setPetkind(pkind);
						ps.setPetname(pname);
						PetSerService petSerService = new PetSerServiceImpl();
						boolean isOk = petSerService.update(ps);
						if (isOk) {
							list = petSerService.findAll();
							DefaultTableModel defaultTableModel = refreshTableData1(columuNames);
							// ��������table�е�ģ��
							tblData.setModel(defaultTableModel);
							// ����UI
							tblData.updateUI();
							clearUpTxt();
							rowNum = -1;

						} else {
							// ʧ��
							JOptionPane.showMessageDialog(null, "����ʧ�ܣ�");
						}
					}
				} else {
					System.out.println("δѡ���¼");
				}
			}

		});

		deleteBtn = new JButton("ɾ��");
		deleteBtn.setBounds(644, 570, 90, 30);

		deleteBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (rowNum == -1) {
					JOptionPane.showConfirmDialog(null, "���ڱ����ѡ��һ������", "��Ϣ��ʾ", JOptionPane.WARNING_MESSAGE);
				} else {
					String odd = petseroddnum.getText();
					// PetSerService����ɲ������
					PetSerService petSerService = new PetSerServiceImpl();
					boolean isOk = petSerService.delete(odd);
					if (isOk) {
						list = petSerService.findAll();
						DefaultTableModel defaultTableModel = refreshTableData1(columuNames);
						// ��������table�е�ģ��
						tblData.setModel(defaultTableModel);
						// ����UI
						tblData.updateUI();
						clearUpTxt();
						// �ɹ�
						JOptionPane.showMessageDialog(null, "ɾ���ɹ���");
					} else {
						// ʧ��
						JOptionPane.showMessageDialog(null, "ɾ��ʧ�ܣ�");
					}

				}

			}
		});

		exportExcelBtn = new JButton("�����ܼ�");
		exportExcelBtn.setBounds(764, 570, 120, 30);

		exportExcelBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//���㱾ҳ��������۽��
				int sum = 0;
				dataObject = new Object[list.size()][columuNames.length];
				for (int i = 0; i < list.size(); i++) {
					PetSer petser1 = list.get(i);
					dataObject[i][7] = petser1.getCharge();
					int money = Integer.parseInt((String) dataObject[i][7]);
					sum=sum+money;
				}
				JOptionPane.showMessageDialog(null, "��ҳ�����ܼƣ�"+sum+"Ԫ");
			}
		});

		backBtn = new JButton("����");
		backBtn.setBounds(908, 570, 90, 30);

		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new WelcomePetSerFrame();
				setVisible(false);
			}
		});

		label1 = new JLabel();
		label1.setBounds(420, 400, 180, 60);

		// �½�һ��Lable
		JLabel lbIcon = new JLabel();
		// �½�һ��ImageIcon
		ImageIcon imageIcon = new ImageIcon("src/back3.jpg");

		Image image = imageIcon.getImage();
		// ��ͼƬ����ѹ�������ݸ����ı������㷨
		Image smallImage = image.getScaledInstance(1100, 680, Image.SCALE_FAST);
		// �����ĵ�ImageIcon
		ImageIcon smImageIcon = new ImageIcon(smallImage);
		// ��ImageIcon���õ�label��
		lbIcon.setIcon(smImageIcon);

		add(oddnum);
		add(petseroddnum);
		add(serviceitem);
		add(petserserviceitem);
		add(cusname);
		add(petsercusname);
		add(cusmale);
		add(petsercusmale);
		add(query);
		add(first);
		add(next);
		add(previous);
		add(last);
		add(modifyBtn);
		add(deleteBtn);
		add(exportExcelBtn);
		add(exportExcelBtn);
		add(backBtn);
		add(label2);
		add(label1);
		add(jScrollPane);
		add(box);
		add(cusphone);
		add(petsercusphone);
		add(cusaddress);
		add(petsercusaddress);
		add(ordertime);
		add(petserordertime);
		add(charge);
		add(petsercharge);
		add(petkind);
		add(petserpetkind);
		add(petname);
		add(petserpetname);
		add(btnadd);
		add(lbIcon);

		// setLayout(null);
		setVisible(true);

	}

	private DefaultTableModel refreshTableData1(String[] columuNames) {
		dataObject = new Object[list.size()][columuNames.length];
		for (int i = 0; i < list.size(); i++) {
			PetSer petser1 = list.get(i);
			dataObject[i][0] = petser1.getOddnum();
			dataObject[i][1] = petser1.getServiceitem();
			dataObject[i][2] = petser1.getCusname();
			dataObject[i][3] = petser1.getCusmale();
			dataObject[i][4] = petser1.getCusphone();
			dataObject[i][5] = petser1.getCusaddress();
			dataObject[i][6] = petser1.getOrdertime();
			dataObject[i][7] = petser1.getCharge();
			dataObject[i][8] = petser1.getPetkind();
			dataObject[i][9] = petser1.getPetname();

		}
		DefaultTableModel defaultTableModel = new DefaultTableModel(dataObject, columuNames) {

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

		};
		return defaultTableModel;
	}

	private DefaultTableModel refreshTableData(String[] columuNames, PetSerService petSerService) {
		list = petSerService.findAll();
		dataObject = new Object[list.size()][columuNames.length];
		for (int i = 0; i < list.size(); i++) {
			PetSer petser1 = list.get(i);
			dataObject[i][0] = petser1.getOddnum();
			dataObject[i][1] = petser1.getServiceitem();
			dataObject[i][2] = petser1.getCusname();
			dataObject[i][3] = petser1.getCusmale();
			dataObject[i][4] = petser1.getCusphone();
			dataObject[i][5] = petser1.getCusaddress();
			dataObject[i][6] = petser1.getOrdertime();
			dataObject[i][7] = petser1.getCharge();
			dataObject[i][8] = petser1.getPetkind();
			dataObject[i][9] = petser1.getPetname();

		}
		DefaultTableModel defaultTableModel = new DefaultTableModel(dataObject, columuNames) {

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

		};
		return defaultTableModel;
	}

	// ���Txt��������
	private void clearUpTxt() {
		petseroddnum.setText("");
		petserserviceitem.setText("");
		petsercusname.setText("");
		petsercusmale.setText("");
		petsercusphone.setText("");
		petsercusaddress.setText("");
		petserordertime.setText("");
		petsercharge.setText("");
		petserpetkind.setText("");
		petserpetname.setText("");
	}

}
