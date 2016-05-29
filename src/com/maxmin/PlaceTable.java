//package com.maxmin;
//
//import java.awt.GridLayout;
//import java.awt.Label;
//import java.util.ArrayList;
//
//import javax.swing.JPanel;
//import javax.swing.event.ChangeEvent;
//import javax.swing.event.ChangeListener;
//
//public class PlaceTable {
//
//	final JPanel panel4 = makePanel("Jobs");
//	placeTableUi(panel4);
//	tabbedPane.addTab("Jobs", panel4);
//
//	tabbedPane.addChangeListener(new ChangeListener() {
//
//		public void stateChanged(ChangeEvent e) {
//
//			if (tabbedPane.getSelectedIndex() == 3) {
//				placeTableUi(panel4);
//
//			}
//
//			frame.getContentPane().add(tabbedPane);
//		}
//	});
//}
//private static JPanel makePanel(String text) {
//		JPanel p = new JPanel();
//		p.add(new Label(text));
//		p.setLayout(new GridLayout(1, 1));
//		return p;
//	}
//
//	public void placeTableUi(JPanel panel) {
//		panel.removeAll();
//		ArrayList<Job> jobs = new ArrayList<Job>(Job);
//		int size = jobs.size();
//		Object rowData[][] = new Object[size][3];
//		for (int i = 0; i < jobs.size(); i++) {
//			Job job = jobs.get(i);
//			rowData[i][0] = Job.getJobId();
//			rowData[i][1] = job.getCategory();
//			rowData[i][2] = job.getCpuTime();
//	
//		}
//}
//}
