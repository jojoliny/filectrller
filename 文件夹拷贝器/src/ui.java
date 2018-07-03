import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class ui extends JFrame {

	JTextField srcPath = null;// 原
	JTextField destPath = null;// 目的
	JButton copy;// 确认拷贝
	JButton src;
	JButton dest;
	String srcText = null;
	String destText = null;

	public ui() {
		/** 界面 **/
		setTitle("文件拷贝器");
		setSize(700, 300);
		setLayout(null);
		setLocationRelativeTo(null);
		srcPath = new JTextField();
		destPath = new JTextField();
		src = new JButton("源文件或文件夹");
		dest = new JButton("目标文件或文件夹");
		copy = new JButton("确认拷贝");
		srcPath.setBounds(20, 20, 450, 30);
		destPath.setBounds(20, 70, 450, 30);
		src.setBounds(480, 20, 150, 30);
		dest.setBounds(480, 70, 150, 30);
		copy.setBounds(250, 120, 100, 30);
		add(srcPath);
		add(destPath);
		add(src);
		add(dest);
		add(copy);
		setVisible(true);

		/** 监听 **/
		src.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				chooser.showOpenDialog(null);
				srcText = chooser.getSelectedFile().getAbsolutePath();
				srcPath.setText(srcText);
			}
		});

		dest.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				chooser.showOpenDialog(null);
				destText = chooser.getSelectedFile().getAbsolutePath();
				destPath.setText(destText);
			}
		});

		copy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FileTool fileTool = new FileTool();
				fileTool.copyFolder(srcText, destText);
			}
		});
	}

	public static void main(String[] args) {
		ui u = new ui();

	}
}
