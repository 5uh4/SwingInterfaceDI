package main;

import javax.swing.SwingUtilities;

import views.MainFrame;

public class Practica2Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MainFrame();
			}
		});
//		new MainFrame();
	}
}
