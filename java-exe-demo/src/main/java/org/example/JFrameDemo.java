package org.example;

import org.springframework.util.ResourceUtils;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class JFrameDemo extends JFrame {
	 public JFrameDemo() throws FileNotFoundException {
		  setTitle("Java 第一个 GUI 程序");    //设置显示窗口标题
		  setSize(600, 400);    //设置窗口显示尺寸
		  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //置窗口是否可以关闭
		  JLabel jl = new JLabel(ResourceUtils.getFile("application.yml").getName());    //创建一个标签
		  Container c = getContentPane();    //获取当前窗口的内容窗格
		  c.add(jl);    //将标签组件添加到内容窗格上

		  setVisible(true);    //设置窗口是否可见
	 }

	 public static void main(String[] agrs) throws FileNotFoundException {
		  new JFrameDemo();    //创建一个实例化对象
	 }
}