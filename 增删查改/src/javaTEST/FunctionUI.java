package javaTEST;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

//��ɾ��Ľ���
public class FunctionUI extends JFrame {
	static String Path1;// ԭ��ַ
	static String Path2;// Ŀ�ĵ�ַ
	static String Path3;// ɾ���ļ�
	static String Path4;// �����ļ�

	public void showUI() {
		// ����
		setSize(515, 450);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);
		setLayout(null);

		/*
		 * �ļ�����
		 */
		// ��ǩ
		JLabel fileCopy = new JLabel("�ļ�����");
		JLabel src = new JLabel("Դ·��");
		JLabel dest = new JLabel("Ŀ��·��");
		fileCopy.setBounds(10, 12, 70, 20);
		src.setBounds(10, 40, 70, 20);
		dest.setBounds(10, 65, 70, 20);
		// Դ·��
		JTextField srcPath = new JTextField();
		srcPath.setEditable(true);
		srcPath.setBounds(80, 40, 365, 20);
		// Ŀ��·��
		JTextField destPath = new JTextField();
		destPath.setEditable(true);
		destPath.setBounds(80, 65, 365, 20);
		// ѡ��ť
		JButton button1 = new JButton("...");
		button1.setBounds(450, 40, 30, 20);
		JButton button2 = new JButton("...");
		button2.setBounds(450, 65, 30, 20);
		// aaaת��bbb
		JTextField aaa = new JTextField();
		JTextField bbb = new JTextField();
		aaa.setBounds(10, 100, 200, 20);
		bbb.setBounds(280, 100, 200, 20);
		JLabel convertTo = new JLabel("ת��");
		convertTo.setBounds(230, 100, 60, 20);
		// ������ť
		JButton copy = new JButton("ȷ�Ͽ���");
		copy.setBounds(195, 135, 100, 20);
		// ��ӵ�����
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
		 * �ļ�ɾ��
		 */
		// ��ǩ 28 �ļ�ɾ���� ·��
		JLabel fileDelete = new JLabel("�ļ�ɾ��");
		fileDelete.setBounds(10, 172, 70, 20);
		JLabel path = new JLabel("·��");
		path.setBounds(10, 200, 70, 20);
		// �ı��� ·��
		JTextField route = new JTextField();
		route.setEditable(true);
		route.setBounds(80, 200, 365, 20);
		// ��ť�� ѡ��ɾ��
		JButton button3 = new JButton("...");
		button3.setBounds(450, 200, 30, 20);
		JButton delete = new JButton("ɾ��");
		delete.setBounds(195, 235, 100, 20);
		// ��ӵ�����
		add(fileDelete);
		add(path);
		add(route);
		add(button3);
		add(delete);

		/*
		 * �ļ�����
		 */
		// ��ǩ�� �ļ����棬 Ŀ��·��
		JLabel fileSave = new JLabel("�ļ�����");
		fileSave.setBounds(10, 277, 70, 20);
		JLabel destSave = new JLabel("Ŀ��·��");
		destSave.setBounds(10, 305, 70, 20);
		// �ı��� Ŀ��·���� �����
		JTextField savePath = new JTextField();
		savePath.setBounds(80, 305, 365, 20);
		savePath.setEditable(true);
		JTextField enter = new JTextField();
		enter.setBounds(10, 330, 415, 20);
		enter.setEditable(true);
		// ��ť�� ѡ�� ����
		JButton button4 = new JButton("...");
		button4.setBounds(450, 305, 30, 20);
		JButton save = new JButton("����");
		save.setBounds(430, 330, 60, 20);
		// ���
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
				// ���ú�׺��
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

		// ȷ�Ͽ���
		copy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String srcWord = aaa.getText();
				String destWord = bbb.getText();
				// FileTool ft = new FileTool();
				FileTool.copyFile(Path1, Path2, srcWord, destWord);
			}

		});

		// ɾ��
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileTool ft = new FileTool();
				Path3 = route.getText();
				ft.deleteFolder(Path3);
			}
		});

		// ����
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
