package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Checkbox;
import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JInternalFrame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainList {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MainList window = new MainList();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 * @param name 
	 */
	public MainList(String name) {
		initialize(name);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param name 
	 */
	private void initialize(String name) {
		frame = new JFrame();
		frame.setBounds(100, 100, 315, 547);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel label_name = new JLabel(name);
		label_name.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label_name, BorderLayout.NORTH);
		
		Checkbox checkbox = new Checkbox("online");
		checkbox.setState(true);
		panel.add(checkbox, BorderLayout.WEST);
		
		JButton button = new JButton("切换账号");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int	m =JOptionPane.showConfirmDialog(null, "是否退出并切换账号", "切换账号",JOptionPane.YES_NO_OPTION);
				//if(m==0) cQuit(name);
			}
		});
		panel.add(button, BorderLayout.EAST);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.NORTH);
		
		JButton btnNewButton = new JButton("添加新好友");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new AddFriends().frame.setVisible(true);
			}
		});
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("好友请求");
		panel_2.add(btnNewButton_1);
		
		DefaultListModel<String> dlm = new DefaultListModel<String>();
		dlm.addElement("item1");
		dlm.addElement("item2");
		dlm.addElement("item3");
		JList<String> list = new JList<String>(dlm);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
				try {
					System.out.println(list.getSelectedValue());

					Chat chat = new Chat();
					chat.frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			}
		});


		panel_1.add(list, BorderLayout.CENTER);
	}
}
