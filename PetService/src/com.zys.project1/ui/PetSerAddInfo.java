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
	private JLabel label1, label2; // 1.显示总页数和当前页数 2.每页显示数

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

		setTitle("添加服务信息");
		setSize(1040, 680);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// 设置表格的标题
		String[] columuNames = { "订单号", "服务项目", "顾客姓名", "顾客性别", "顾客电话", "家庭地址", "下单时间", "消费金额", "宠物类别", "宠物名字" };

		String[] array = { "10", "20", "30", "40", "50" };
		JComboBox box = new JComboBox(array);

		// 获取数据库中的数据
		petSerService = new PetSerServiceImpl();
		DefaultTableModel defaultTableModel = refreshTableData(columuNames, petSerService);

		tblData = new JTable(defaultTableModel);

		// 设置表格内容颜色
		tblData.setForeground(Color.BLACK); // 字体颜色
		tblData.setFont(new Font(null, Font.PLAIN, 14)); // 字体样式
		tblData.setSelectionForeground(Color.DARK_GRAY); // 选中后字体颜色
		tblData.setSelectionBackground(Color.LIGHT_GRAY); // 选中后字体背景
		tblData.setGridColor(Color.GRAY); // 网格颜色

		// 设置表头
		tblData.getTableHeader().setFont(new Font(null, Font.BOLD, 14)); // 设置表头名称字体样式
		tblData.getTableHeader().setForeground(Color.BLACK); // 设置表头名称字体颜色
		tblData.getTableHeader().setResizingAllowed(false); // 设置不允许手动改变列宽
		tblData.getTableHeader().setReorderingAllowed(false); // 设置不允许拖动重新排序各列

		// 设置行高
		tblData.setRowHeight(30);

		// 第一列列宽设置为40
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

				// System.out.println("鼠标点击了");
				// 检测鼠标双击
				if (e.getClickCount() == 2) {
					System.out.println("鼠标双击了");
					// 获取双击了哪行数据
					rowNum = tblData.rowAtPoint(e.getPoint());
					System.out.println("双击了，下标为" + (rowNum + 1) + "的数据");
					// 通过下标拿到数据
					System.out.println("姓名为：" + dataObject[rowNum][2]);
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

		Font font = new Font("仿宋", Font.CENTER_BASELINE, 14);

		oddnum = new JLabel("订单号");
		oddnum.setBounds(40, 30, 70, 30);
		oddnum.setFont(font);

		petseroddnum = new JTextField();
		petseroddnum.setBounds(100, 30, 100, 30);

		serviceitem = new JLabel("服务项目");
		serviceitem.setBounds(210, 30, 70, 30);
		serviceitem.setFont(font);

		petserserviceitem = new JTextField();
		petserserviceitem.setBounds(280, 30, 100, 30);

		cusname = new JLabel("顾客姓名");
		cusname.setBounds(40, 65, 60, 30);
		cusname.setFont(font);

		petsercusname = new JTextField();
		petsercusname.setBounds(100, 65, 100, 30);

		cusmale = new JLabel("顾客性别");
		cusmale.setBounds(210, 65, 70, 30);
		cusmale.setFont(font);

		petsercusmale = new JTextField();
		petsercusmale.setBounds(280, 65, 100, 30);

		cusphone = new JLabel("顾客电话");
		cusphone.setBounds(390, 30, 70, 30);
		cusphone.setFont(font);

		petsercusphone = new JTextField();
		petsercusphone.setBounds(460, 30, 100, 30);

		cusaddress = new JLabel("顾客地址");
		cusaddress.setBounds(390, 65, 70, 30);
		cusaddress.setFont(font);

		petsercusaddress = new JTextField();
		petsercusaddress.setBounds(460, 65, 100, 30);

		ordertime = new JLabel("下单时间");
		ordertime.setBounds(570, 30, 70, 30);
		ordertime.setFont(font);

		petserordertime = new JTextField();
		petserordertime.setBounds(640, 30, 100, 30);

		charge = new JLabel("消费金额");
		charge.setBounds(570, 65, 70, 30);
		charge.setFont(font);

		petsercharge = new JTextField();
		petsercharge.setBounds(640, 65, 100, 30);

		petkind = new JLabel("宠物种类");
		petkind.setBounds(750, 30, 70, 30);
		petkind.setFont(font);

		petserpetkind = new JTextField();
		petserpetkind.setBounds(820, 30, 100, 30);

		petname = new JLabel("宠物名字");
		petname.setBounds(750, 65, 70, 30);
		petname.setFont(font);

		petserpetname = new JTextField();
		petserpetname.setBounds(820, 65, 100, 30);

		query = new JButton("查询");
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
					// 更新UI
					tblData.updateUI();
					page++;
				} else if (!"".equals(cname)) {
					list = petSerService.findPetSerByName(cname);
					DefaultTableModel defaultTableModel = refreshTableData1(columuNames);
					tblData.setModel(defaultTableModel);
					// 更新UI
					tblData.updateUI();
					page++;
				} else {
					// 失败
					JOptionPane.showMessageDialog(null, "查找失败！");
				}

			}

		});

		btnadd = new JButton("添加");
		btnadd.setBounds(925, 30, 90, 30);
		// query.setFont(font);
		btnadd.setForeground(Color.blue);
		ImageIcon icon2 = new ImageIcon("src/com/zys/project1/images/icons/add.png");
		btnadd.setIcon(icon2);

		// 添加按钮的按钮监听
		btnadd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 保存学生信息
				// 1.拿到输入框的学生信息
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
				// 还需要做校验
				if ((!"".equals(odd)) && (!"".equals(cname)) && (!"".equals(ser))) {
					// 执行数据库插入
					// 实例一个Student对象
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
					// PetSerService，完成插入操作
					PetSerService petSerService = new PetSerServiceImpl();
					boolean isOk = petSerService.save(ps);
					if (isOk) {
						list = petSerService.findAll();
						DefaultTableModel defaultTableModel = refreshTableData1(columuNames);
						// 重新设置table中的模型
						tblData.setModel(defaultTableModel);
						// 更新UI
						tblData.updateUI();
						clearUpTxt();
					} else {
						// 失败
						JOptionPane.showMessageDialog(null, "插入失败！");
					}

				}
			}
		});
		
		
		box.setBounds(890, 105, 100, 20);
		
		label2 = new JLabel("每页显示条数:");
		label2.setBounds(800, 93, 120, 50);
		jScrollPane = new JScrollPane();// 设置滚动条
		jScrollPane.setViewportView(tblData);
		jScrollPane.setBounds(42, 136, 950, 420);
		jScrollPane.setOpaque(false);
		jScrollPane.getViewport().setOpaque(false);
		// 边框样式斜面边框（凹）
		jScrollPane.setBorder(BorderFactory.createLoweredBevelBorder());

		first = new JButton("第一页");
		first.setBounds(44, 570, 90, 30);

		first.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int pageSize = Integer.parseInt((String) box.getSelectedItem());
				if (page == 1) {
					JOptionPane.showMessageDialog(null, "当前已在第一页！");
				} else {
					int firstpage = 1;
					list = petSerService.findAllByPage(pageSize, firstpage);
					DefaultTableModel defaultTableModel = refreshTableData1(columuNames);
					// 重新设置table中的模型
					tblData.setModel(defaultTableModel);
					// 更新UI
					tblData.updateUI();
					page = 1;
				}

			}
		});

		previous = new JButton("上一页");
		previous.setBounds(164, 570, 90, 30);

		previous.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int pageSize = Integer.parseInt((String) box.getSelectedItem());
				if (page == 1) {
					JOptionPane.showMessageDialog(null, "当前已在第一页！");
				} else {
					list = petSerService.findAllByPage(pageSize, page - 1);
					DefaultTableModel defaultTableModel = refreshTableData1(columuNames);
					// 重新设置table中的模型
					tblData.setModel(defaultTableModel);
					// 更新UI
					tblData.updateUI();
					page--;
				}

			}
		});

		next = new JButton("下一页");
		next.setBounds(284, 570, 90, 30);

		next.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int pageSize = Integer.parseInt((String) box.getSelectedItem());
				list = petSerService.findAllByPage(pageSize, page + 1);
				if (list.size() != 0) {
					DefaultTableModel defaultTableModel = refreshTableData1(columuNames);
					// 重新设置table中的模型
					tblData.setModel(defaultTableModel);
					// 更新UI
					tblData.updateUI();
					page++;
				} else {
					JOptionPane.showMessageDialog(null, "当前已在最后一页！");
				}

			}
		});

		last = new JButton("分页");
		last.setBounds(404, 570, 90, 30);

		last.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int pageSize = Integer.parseInt((String) box.getSelectedItem());
				list = petSerService.findAllByPage(pageSize, page);
				DefaultTableModel defaultTableModel = refreshTableData1(columuNames);
				// 重新设置table中的模型
				tblData.setModel(defaultTableModel);
				// 更新UI
				tblData.updateUI();

			}
		});

		modifyBtn = new JButton("修改");
		modifyBtn.setBounds(524, 570, 90, 30);

		modifyBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (rowNum > -1) {
					System.out.println("选择了记录");
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
						// 进行修改
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
							// 重新设置table中的模型
							tblData.setModel(defaultTableModel);
							// 更新UI
							tblData.updateUI();
							clearUpTxt();
							rowNum = -1;

						} else {
							// 失败
							JOptionPane.showMessageDialog(null, "插入失败！");
						}
					}
				} else {
					System.out.println("未选择记录");
				}
			}

		});

		deleteBtn = new JButton("删除");
		deleteBtn.setBounds(644, 570, 90, 30);

		deleteBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (rowNum == -1) {
					JOptionPane.showConfirmDialog(null, "请在表格中选中一条数据", "消息提示", JOptionPane.WARNING_MESSAGE);
				} else {
					String odd = petseroddnum.getText();
					// PetSerService，完成插入操作
					PetSerService petSerService = new PetSerServiceImpl();
					boolean isOk = petSerService.delete(odd);
					if (isOk) {
						list = petSerService.findAll();
						DefaultTableModel defaultTableModel = refreshTableData1(columuNames);
						// 重新设置table中的模型
						tblData.setModel(defaultTableModel);
						// 更新UI
						tblData.updateUI();
						clearUpTxt();
						// 成功
						JOptionPane.showMessageDialog(null, "删除成功！");
					} else {
						// 失败
						JOptionPane.showMessageDialog(null, "删除失败！");
					}

				}

			}
		});

		exportExcelBtn = new JButton("销售总计");
		exportExcelBtn.setBounds(764, 570, 120, 30);

		exportExcelBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//计算本页表格总销售金额
				int sum = 0;
				dataObject = new Object[list.size()][columuNames.length];
				for (int i = 0; i < list.size(); i++) {
					PetSer petser1 = list.get(i);
					dataObject[i][7] = petser1.getCharge();
					int money = Integer.parseInt((String) dataObject[i][7]);
					sum=sum+money;
				}
				JOptionPane.showMessageDialog(null, "本页销售总计："+sum+"元");
			}
		});

		backBtn = new JButton("返回");
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

		// 新建一个Lable
		JLabel lbIcon = new JLabel();
		// 新建一个ImageIcon
		ImageIcon imageIcon = new ImageIcon("src/back3.jpg");

		Image image = imageIcon.getImage();
		// 对图片进行压缩，根据给定的比例和算法
		Image smallImage = image.getScaledInstance(1100, 680, Image.SCALE_FAST);
		// 生成心得ImageIcon
		ImageIcon smImageIcon = new ImageIcon(smallImage);
		// 把ImageIcon设置到label中
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

	// 清空Txt框中内容
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
