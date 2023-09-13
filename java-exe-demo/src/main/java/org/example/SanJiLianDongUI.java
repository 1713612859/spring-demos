package org.example;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 *
 *
 * @author Zkingzz
 *
 */
public class SanJiLianDongUI extends JFrame {
	 // 中间组件
	 private JPanel jpa = new JPanel();

	 private JComboBox jcba = new JComboBox();
	 private JComboBox jcbb = new JComboBox();

	 public SanJiLianDongUI() {
		  this.setTitle("");
		  this.setSize(500, 300);
		  this.setDefaultCloseOperation(3);
		  this.setLocationRelativeTo(null);
		  this.setUndecorated(true);// 去掉窗体边框
		  jcba.addItem("请选择");
		  jcba.addItem("湖南省");
		  jcba.addItem("湖北省");
		  jcba.addItem("河南省");
		  jcba.addItem("河北省");
		  jcba.addItem("陕西省");

		  jpa.add(jcba);
		  jpa.add(jcbb);

		  // 下拉框改变事件
		  jcba.addItemListener(new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent e) {
					 jcbb.removeAllItems();//清空上一次所有的数据
					 String pro = jcba.getSelectedItem().toString();
					 if ("湖南省".equals(pro)) {
						  jcbb.addItem("长沙市");
						  jcbb.addItem("湘潭市");
						  jcbb.addItem("邵阳市");
						  jcbb.addItem("衡阳市");
						  jcbb.addItem("益阳市");
					 }

				}
		  });

		  this.getContentPane().add(jpa);
		  this.setVisible(true);
	 }

	 public static void main(String[] args) {
		  new SanJiLianDongUI();
	 }
}