package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
import java.util.Map;

public class demon {

	 private JFrame frame;
	 private JTextField led_port;
	 private JTextField led_ip_address;
	 private JTextField dibang_1_port;
	 private JTextField dibang_1_potelv;
	 private JTextField dibang_1_databit;
	 private JTextField dibang_1_stop_bit;
	 private JTextField dibang_1_jiaoyan_bit;

	 // rfid 列表
	 private static Map<String, String> rfidList = new HashMap<>();
	 // idcard 列表
	 private static Map<String, String> idcardList = new HashMap<>();
	 // weigh 地磅列表
	 private static Map<String, String> weighList = new HashMap<>();
	 // led 列表
	 private static Map<String, String> ledList = new HashMap<>();

	 static {
		  rfidList.put("德卡", "com.zkhy.zhlkdevice.device.rfid.service.impl.DkD8RfidServiceImpl"); // 德卡（default）
		  rfidList.put("优博讯", "com.zkhy.zhlkdevice.device.rfid.service.impl.YouBoXunRfidServiceImpl"); // 优博讯
		  rfidList.put("明华", "com.zkhy.zhlkdevice.device.rfid.service.impl.MingHuaRfidServiceImpl"); // 明华

		  idcardList.put("华视", "com.zkhy.zhlkdevice.device.idCard.service.impl.IdCardServiceImpl"); // 华视（default）
		  idcardList.put("神思", "com.zkhy.zhlkdevice.device.idCard.service.impl.ShenSiCardServiceImpl"); // 神思

		  weighList.put("托利多", "com.zkhy.zhlkdevice.device.weight.service.impl.WeightServiceImpl");// 托利多（default）
		  weighList.put("金钟", "com.zkhy.zhlkdevice.device.weight.service.impl.JinZhongWeightServiceImpl");// 金钟

		  ledList.put("仰邦", "com.zkhy.zhlkdevice.device.led.service.impl.LedServiceImpl"); // 仰邦(default)
		  ledList.put("有人", "com.zkhy.zhlkdevice.device.led.service.impl.YouRenLedServiceImpl");// 有人
	 }


	 /**
	  * Launch the application.
	  */
	 public static void main(String[] args) {
		  EventQueue.invokeLater(new Runnable() {
				public void run() {
					 try {
						  demon window = new demon();
						  window.frame.setVisible(true);
					 }
					 catch (Exception e) {
						  e.printStackTrace();
					 }
				}
		  });
	 }

	 /**
	  * Create the application.
	  */
	 public demon() {
		  initialize();
	 }

	 /**
	  * Initialize the contents of the frame.
	  */
	 private void initialize() {
		  frame = new JFrame();
		  frame.setTitle("\u667A\u6167\u7CAE\u5E93\u63D2\u4EF6");
		  frame.setBounds(100, 100, 777, 431);
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  frame.getContentPane().setLayout(null);

		  JLabel rfidLabel = new JLabel("rfid\u8BFB\u5361\u5668");
		  rfidLabel.setFont(new Font("微软雅黑", Font.BOLD, 18));
		  rfidLabel.setBounds(604, 20, 122, 39);
		  frame.getContentPane().add(rfidLabel);

		  JLabel idcardLabel = new JLabel("\u8EAB\u4EFD\u8BC1\u8BFB\u5361\u5668");
		  idcardLabel.setFont(new Font("微软雅黑", Font.BOLD, 18));
		  idcardLabel.setBounds(430, 20, 122, 39);
		  frame.getContentPane().add(idcardLabel);

		  JLabel dibangLabel = new JLabel("\u5730\u78C5");
		  dibangLabel.setFont(new Font("微软雅黑", Font.BOLD, 18));
		  dibangLabel.setBounds(268, 20, 122, 39);

		  frame.getContentPane().add(dibangLabel);

		  JLabel ledLabel = new JLabel("LED");
		  ledLabel.setFont(new Font("微软雅黑", Font.BOLD, 18));
		  ledLabel.setBounds(65, 20, 122, 39);
		  frame.getContentPane().add(ledLabel);

		  // led下拉框
		  final JComboBox led_comboBox = new JComboBox();
		  for (String key : ledList.keySet()) {
				led_comboBox.addItem(key);
		  }
		  led_comboBox.setFont(new Font("微软雅黑", Font.BOLD, 18));
		  led_comboBox.setBounds(26, 69, 122, 30);
		  led_comboBox.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					 String selectItem = led_comboBox.getSelectedItem().toString();
					 System.out.println(selectItem);
				}
		  });
		  frame.getContentPane().add(led_comboBox);

		  final JComboBox wegin_comboBox_1 = new JComboBox();
		  for (String key : weighList.keySet()) {
				wegin_comboBox_1.addItem(key);
		  }
		  wegin_comboBox_1.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					 String selectItem = wegin_comboBox_1.getSelectedItem().toString();
					 System.out.println(selectItem);
				}
		  });
		  wegin_comboBox_1.setFont(new Font("微软雅黑", Font.BOLD, 18));
		  wegin_comboBox_1.setBounds(243, 73, 116, 30);
		  frame.getContentPane().add(wegin_comboBox_1);

		  final JComboBox idcard_comboBox_2 = new JComboBox();
		  for (String idCardKey : idcardList.keySet()) {
				idcard_comboBox_2.addItem(idCardKey);
		  }
		  idcard_comboBox_2.setFont(new Font("微软雅黑", Font.BOLD, 18));
		  idcard_comboBox_2.setBounds(430, 73, 110, 30);
		  idcard_comboBox_2.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					 String selectItem = idcard_comboBox_2.getSelectedItem().toString();
					 System.out.println(selectItem);
				}
		  });
		  frame.getContentPane().add(idcard_comboBox_2);

		  final JComboBox rfid_comboBox_3 = new JComboBox();
		  for (String rfidKey : rfidList.keySet()) {
				rfid_comboBox_3.addItem(rfidKey);
		  }
		  rfid_comboBox_3.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		  rfid_comboBox_3.setFont(new Font("微软雅黑", Font.BOLD, 18));
		  rfid_comboBox_3.setBounds(600, 73, 110, 30);
		  rfid_comboBox_3.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					 String selectItem = rfid_comboBox_3.getSelectedItem().toString();
					 System.out.println(selectItem);
				}
		  });
		  frame.getContentPane().add(rfid_comboBox_3);

		  led_ip_address = new JTextField();
		  led_ip_address.setBounds(65, 130, 122, 30);
		  frame.getContentPane().add(led_ip_address);
		  led_ip_address.setColumns(10);

		  led_port = new JTextField();
		  led_port.setColumns(10);
		  led_port.setBounds(65, 187, 122, 30);
		  frame.getContentPane().add(led_port);

		  // LED IP地址
		  JLabel led_ip_label = new JLabel("Ip\u5730\u5740\uFF1A");
		  led_ip_label.setFont(new Font("宋体", Font.BOLD, 16));
		  led_ip_label.setBounds(0, 137, 68, 23);
		  frame.getContentPane().add(led_ip_label);

		  // LED 端口号
		  JLabel led_ip_label_1 = new JLabel("\u7AEF\u53E3\u53F7\uFF1A");
		  led_ip_label_1.setFont(new Font("宋体", Font.BOLD, 16));
		  led_ip_label_1.setBounds(0, 194, 68, 23);
		  frame.getContentPane().add(led_ip_label_1);

		  final JLabel dibang_chuangkou = new JLabel("\u7AEF\u53E3\uFF1A");
		  dibang_chuangkou.setFont(new Font("宋体", Font.BOLD, 16));
		  dibang_chuangkou.setBounds(197, 137, 50, 23);
		  frame.getContentPane().add(dibang_chuangkou);

		  final JLabel dibang_baud = new JLabel("\u6CE2\u7279\u7387\uFF1A");
		  dibang_baud.setFont(new Font("宋体", Font.BOLD, 16));
		  dibang_baud.setBounds(197, 189, 68, 23);
		  frame.getContentPane().add(dibang_baud);

		  JLabel diabng_databit = new JLabel("\u6570\u636E\u4F4D\uFF1A");
		  diabng_databit.setFont(new Font("宋体", Font.BOLD, 16));
		  diabng_databit.setBounds(197, 245, 68, 23);
		  frame.getContentPane().add(diabng_databit);

		  final JLabel dibang_stopbit = new JLabel("\u505C\u6B62\u4F4D\uFF1A");
		  dibang_stopbit.setFont(new Font("宋体", Font.BOLD, 16));
		  dibang_stopbit.setBounds(197, 294, 68, 23);
		  frame.getContentPane().add(dibang_stopbit);

		  final JLabel dibang_partity = new JLabel("\u6821\u9A8C\u4F4D\uFF1A");
		  dibang_partity.setFont(new Font("宋体", Font.BOLD, 16));
		  dibang_partity.setBounds(197, 341, 68, 23);
		  frame.getContentPane().add(dibang_partity);

		  dibang_1_port = new JTextField();
		  dibang_1_port.setColumns(10);
		  dibang_1_port.setBounds(268, 130, 122, 30);
		  frame.getContentPane().add(dibang_1_port);

		  dibang_1_potelv = new JTextField();
		  dibang_1_potelv.setColumns(10);
		  dibang_1_potelv.setBounds(268, 187, 122, 30);
		  frame.getContentPane().add(dibang_1_potelv);

		  dibang_1_databit = new JTextField();
		  dibang_1_databit.setColumns(10);
		  dibang_1_databit.setBounds(268, 243, 122, 30);
		  frame.getContentPane().add(dibang_1_databit);

		  dibang_1_stop_bit = new JTextField();
		  dibang_1_stop_bit.setColumns(10);
		  dibang_1_stop_bit.setBounds(268, 292, 122, 30);
		  frame.getContentPane().add(dibang_1_stop_bit);

		  dibang_1_jiaoyan_bit = new JTextField();
		  dibang_1_jiaoyan_bit.setColumns(10);
		  dibang_1_jiaoyan_bit.setBounds(268, 339, 122, 30);
		  frame.getContentPane().add(dibang_1_jiaoyan_bit);

		  final JButton btnNewButton = new JButton("\u786E\u8BA4");
		  btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 System.out.println("led_port" + led_port.getText());
					 System.out.println("led_ip_address" + led_ip_address.getText());
					 System.out.println("===============dibang=============");
					 System.out.println("dibang_1_stop_bit" + dibang_1_stop_bit.getText());
					 System.out.println("dibang_1_databit" + dibang_1_databit.getText());
					 System.out.println("dibang_1_port" + dibang_1_port.getText());
					 System.out.println("dibang_1_potelv" + dibang_1_potelv.getText());
					 System.out.println("dibang_1_jiaoyan_bit" + dibang_1_jiaoyan_bit.getText());
				}
		  });
		  btnNewButton.setFont(new Font("宋体", Font.BOLD, 18));
		  btnNewButton.setBounds(604, 329, 116, 35);
		  frame.getContentPane().add(btnNewButton);

	 }
}
