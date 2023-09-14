package org.example.test;

import java.awt.*;


/**
 * 系统托盘
 *
 * @author LiuYunLong
 */
public class SystemTrayTest {

	 public static void main(String[] args) {

		  if (!SystemTray.isSupported()) {
				System.out.println("SystemTray is not supported");
				return;
		  }
		  final PopupMenu popup = new PopupMenu();
		  Image image = Toolkit.getDefaultToolkit().getImage("fly.png");
		  TrayIcon trayIcon = new TrayIcon(image, "please open it");

		  final SystemTray tray = SystemTray.getSystemTray();

		  // Create a pop-up menu components
		  MenuItem aboutItem = new MenuItem("About");
		  CheckboxMenuItem cb1 = new CheckboxMenuItem("Set auto size");
		  CheckboxMenuItem cb2 = new CheckboxMenuItem("Set tooltip");
		  Menu displayMenu = new Menu("Display");
		  MenuItem errorItem = new MenuItem("Error");
		  MenuItem warningItem = new MenuItem("Warning");
		  MenuItem infoItem = new MenuItem("Info");
		  MenuItem noneItem = new MenuItem("None");
		  MenuItem exitItem = new MenuItem("Exit");

		  //Add components to pop-up menu
		  popup.add(aboutItem);
		  popup.addSeparator();
		  popup.add(cb1);
		  popup.add(cb2);
		  popup.addSeparator();
		  popup.add(displayMenu);
		  displayMenu.add(errorItem);
		  displayMenu.add(warningItem);
		  displayMenu.add(infoItem);
		  displayMenu.add(noneItem);
		  popup.add(exitItem);

		  exitItem.addActionListener(e -> {
				System.out.println("e = " + e);
		  });

		  trayIcon.setPopupMenu(popup);

		  try {
				tray.add(trayIcon);
		  }
		  catch (AWTException e) {
				System.out.println("TrayIcon could not be added.");
		  }
	 }


}
