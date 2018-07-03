package javaTEST;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileTool {

	// 拷贝
	public static void copyFile(String srcPath, String destPath, String srcWord, String destWord) {
		copyFile(new File(srcPath), new File(destPath), srcWord, destWord);
	}

	// 拷贝文件
	// 重载 用于将路径转化为文件
	// 添加关键字转化功能
	public static void copyFile(File srcFile, File destFile, String srcWord, String destWord) {
		InputStream in = null;
		OutputStream out = null;
		try {
			/*
			 * 1.流
			 */
			in = new FileInputStream(srcFile);
			out = new FileOutputStream(destFile);
			byte[] b = new byte[1024];
			int length = in.read(b); // 返回有效字节数
			/*
			 * 关键字转化 拷贝
			 */
			if (srcFile == null && "".equals(srcFile)) {
				// 不进行关键字转化 拷贝
				while (length != -1) {
					out.write(b, 0, length);
					length = in.read(b);
				}
			} else {// 进行关键字转化
					// 目标关键字为空则默认为""
				if (destWord == null) {
					destWord = "";
				}
				while (length != -1) {
					String string = new String(b, 0, length);// 获取0到length-1的字符串
					string = string.replace(srcWord, destWord);// 关键字替换
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

	// 拷贝文件夹
	public static void copyFolder(String srcPath, String destPath, String srcWord, String destWord) {
		copyFolder(new File(srcPath), new File(destPath), srcWord, destWord);
	}

	public static void copyFolder(File srcFile, File destFile, String srcWord, String destWord) {
		/**
		 * 1.是否存在
		 */
		if (srcFile != null && srcFile.exists()) {
			/**
			 * 2.是否文件夹
			 */
			if (srcFile.isDirectory()) {
				/**
				 * 3.目的文件夹是否存在
				 */
				// file流只能创建文件 不能创建文件夹
				if (!destFile.exists()) {
					destFile.mkdirs();
				}
				/** 4. 拿到文件夹里面的文件或文件夹的那个文件数组！！！ **/
				File[] files = srcFile.listFiles();
				// 遍历递归
				for (File f : files) {
					String string = f.getName();
					File file = new File(destFile, string);
					copyFolder(f, file, srcWord, destWord);
				}
			} else {// 非文件夹则必定是文件
				copyFile(srcFile, destFile, srcWord, destWord);
			}

		}
	}

	// 删除文件
	public static void deleteFolder(String srcPath) {
		deleteFolder(new File(srcPath));
	}

	public static void deleteFolder(File srcFile) {
		/** 1.判断是否存在 **/
		if (srcFile.exists()) {
			/** 2.判断是否是文件夹 **/
			if (srcFile.isDirectory()) {
				File[] files = srcFile.listFiles();
				for (File f : files) {
					deleteFolder(f);
				}
			}
			srcFile.delete();// 文件 删除自己
		} else {
			srcFile.delete();
		}
	}

	public static void saveFile(String path, String content) {
		saveFile(new File(path), content);
	}

	public static void saveFile(File file, String content) {
		/**
		 * 1.判断父类文件夹是否存在
		 */
		if (!file.getParentFile().exists()) {
			file.mkdirs();
		}
		/**
		 * 2.写流 out
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
