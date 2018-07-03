package javaTEST;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileTool {

	// ����
	public static void copyFile(String srcPath, String destPath, String srcWord, String destWord) {
		copyFile(new File(srcPath), new File(destPath), srcWord, destWord);
	}

	// �����ļ�
	// ���� ���ڽ�·��ת��Ϊ�ļ�
	// ��ӹؼ���ת������
	public static void copyFile(File srcFile, File destFile, String srcWord, String destWord) {
		InputStream in = null;
		OutputStream out = null;
		try {
			/*
			 * 1.��
			 */
			in = new FileInputStream(srcFile);
			out = new FileOutputStream(destFile);
			byte[] b = new byte[1024];
			int length = in.read(b); // ������Ч�ֽ���
			/*
			 * �ؼ���ת�� ����
			 */
			if (srcFile == null && "".equals(srcFile)) {
				// �����йؼ���ת�� ����
				while (length != -1) {
					out.write(b, 0, length);
					length = in.read(b);
				}
			} else {// ���йؼ���ת��
					// Ŀ��ؼ���Ϊ����Ĭ��Ϊ""
				if (destWord == null) {
					destWord = "";
				}
				while (length != -1) {
					String string = new String(b, 0, length);// ��ȡ0��length-1���ַ���
					string = string.replace(srcWord, destWord);// �ؼ����滻
					out.write(b, 0, length);
					length = in.read(b);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	// �����ļ���
	public static void copyFolder(String srcPath, String destPath, String srcWord, String destWord) {
		copyFolder(new File(srcPath), new File(destPath), srcWord, destWord);
	}

	public static void copyFolder(File srcFile, File destFile, String srcWord, String destWord) {
		/**
		 * 1.�Ƿ����
		 */
		if (srcFile != null && srcFile.exists()) {
			/**
			 * 2.�Ƿ��ļ���
			 */
			if (srcFile.isDirectory()) {
				/**
				 * 3.Ŀ���ļ����Ƿ����
				 */
				// file��ֻ�ܴ����ļ� ���ܴ����ļ���
				if (!destFile.exists()) {
					destFile.mkdirs();
				}
				/** 4. �õ��ļ���������ļ����ļ��е��Ǹ��ļ����飡���� **/
				File[] files = srcFile.listFiles();
				// �����ݹ�
				for (File f : files) {
					String string = f.getName();
					File file = new File(destFile, string);
					copyFolder(f, file, srcWord, destWord);
				}
			} else {// ���ļ�����ض����ļ�
				copyFile(srcFile, destFile, srcWord, destWord);
			}

		}
	}

	// ɾ���ļ�
	public static void deleteFolder(String srcPath) {
		deleteFolder(new File(srcPath));
	}

	public static void deleteFolder(File srcFile) {
		/** 1.�ж��Ƿ���� **/
		if (srcFile.exists()) {
			/** 2.�ж��Ƿ����ļ��� **/
			if (srcFile.isDirectory()) {
				File[] files = srcFile.listFiles();
				for (File f : files) {
					deleteFolder(f);
				}
			}
			srcFile.delete();// �ļ� ɾ���Լ�
		} else {
			srcFile.delete();
		}
	}

	public static void saveFile(String path, String content) {
		saveFile(new File(path), content);
	}

	public static void saveFile(File file, String content) {
		/**
		 * 1.�жϸ����ļ����Ƿ����
		 */
		if (!file.getParentFile().exists()) {
			file.mkdirs();
		}
		/**
		 * 2.д�� out
		 */
		OutputStream out = null;
		try {
			out = new FileOutputStream(file);
			out.write(content.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null)
					out.close();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				out = null;
			}
		}
	}
}
