package javaTEST;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

//增删查改界面
public class FunctionUI extends JFrame {
	static String Path1;// 原地址
	static String Path2;// 目的地址
	static String Path3;// 删除文件
	static String Path4;// 保存文件

	public void showUI() {
		// 界面
		setSize(515, 450);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);
		setLayout(null);

		/*
		 * 文件拷贝
		 */
		// 标签
		JLabel fileCopy = new JLabel("文件拷贝");
		JLabel src = new JLabel("源路径");
		JLabel dest = new JLabel("目标路径");
		fileCopy.setBounds(10, 12, 70, 20);
		src.setBounds(10, 40, 70, 20);
		dest.setBounds(10, 65, 70, 20);
		// 源路径
		JTextField srcPath = new JTextField();
		srcPath.setEditable(true);
		srcPath.setBounds(80, 40, 365, 20);
		// 目标路径
		JTextField destPath = new JTextField();
		destPath.setEditable(true);
		destPath.setBounds(80, 65, 365, 20);
		// 选择按钮
		JButton button1 = new JButton("...");
		button1.setBounds(450, 40, 30, 20);
		JButton button2 = new JButton("...");
		button2.setBounds(450, 65, 30, 20);
		// aaa转成bbb
		JTextField aaa = new JTextField();
		JTextField bbb = new JTextField();
		aaa.setBounds(10, 100, 200, 20);
		bbb.setBounds(280, 100, 200, 20);
		JLabel convertTo = new JLabel("转成");
		convertTo.setBounds(230, 100, 60, 20);
		// 拷贝按钮
		JButton copy = new JButton("确认拷贝");
		copy.setBounds(195, 135, 100, 20);
		// 添加到界面
		add(fileCopy);
		add(src);
		add(dest);
		add(srcPath);
		add(destPath);
		add(button1);
		add(button2);
		add(aaa);
		add(bbb);
		add(convertTo);
		add(copy);

		/*
		 * 文件删除
		 */
		// 标签 28 文件删除， 路径
		JLabel fileDelete = new JLabel("文件删除");
		fileDelete.setBounds(10, 172, 70, 20);
		JLabel path = new JLabel("路径");
		path.setBounds(10, 200, 70, 20);
		// 文本框： 路径
		JTextField route = new JTextField();
		route.setEditable(true);
		route.setBounds(80, 200, 365, 20);
		// 按钮： 选择，删除
		JButton button3 = new JButton("...");
		button3.setBounds(450, 200, 30, 20);
		JButton delete = new JButton("删除");
		delete.setBounds(195, 235, 100, 20);
		// 添加到界面
		add(fileDelete);
		add(path);
		add(route);
		add(button3);
		add(delete);

		/*
		 * 文件保存
		 */
		// 标签： 文件保存， 目标路径
		JLabel fileSave = new JLabel("文件保存");
		fileSave.setBounds(10, 277, 70, 20);
		JLabel destSave = new JLabel("目标路径");
		destSave.setBounds(10, 305, 70, 20);
		// 文本框： 目标路径， 输入框
		JTextField savePath = new JTextField();
		savePath.setBounds(80, 305, 365, 20);
		savePath.setEditable(true);
		JTextField enter = new JTextField();
		enter.setBounds(10, 330, 415, 20);
		enter.setEditable(true);
		// 按钮： 选择， 保存
		JButton button4 = new JButton("...");
		button4.setBounds(450, 305, 30, 20);
		JButton save = new JButton("保存");
		save.setBounds(430, 330, 60, 20);
		// 添加
		add(fileSave);
		add(destSave);
		add(savePath);
		add(enter);
		add(button4);
		add(save);

		setVisible(true);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser j = new JFileChooser();
				j.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				j.showOpenDialog(null);
				// 设置后缀名
				FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt", "txt");
				j.setFileFilter(filter);
				Path1 = j.getSelectedFile().getAbsolutePath();
				srcPath.setText(Path1);
			}
		});

		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser j = new JFileChooser();
				j.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				j.showOpenDialog(null);
				Path2 = j.getSelectedFile().getAbsolutePath();
				destPath.setText(Path2);

			}

		});

		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser j = new JFileChooser();
				j.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				j.showOpenDialog(null);
				Path3 = j.getSelectedFile().getAbsolutePath();
				route.setText(Path3);

			}

		});

		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser j = new JFileChooser();
				j.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				j.showOpenDialog(null);
				Path4 = j.getSelectedFile().getAbsolutePath();
				savePath.setText(Path4);

			}

		});

		// 确认拷贝
		copy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String srcWord = aaa.getText();
				String destWord = bbb.getText();
				// FileTool ft = new FileTool();
				FileTool.copyFile(Path1, Path2, srcWord, destWord);
			}

		});

		// 删除
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileTool ft = new FileTool();
				Path3 = route.getText();
				ft.deleteFolder(Path3);
			}
		});

		// 保存
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileTool ft = new FileTool();
				Path4 = savePath.getText();
				String content = enter.getText();
				ft.saveFile(Path4, content);
			}
		});
	}

	public static void main(String args[]) {
		FunctionUI fc = new FunctionUI();
		fc.showUI();
	}

}
