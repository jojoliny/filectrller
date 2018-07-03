import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileTool {
	public void copyFolder(String src, String dest) {
		copyFolder(new File(src), new File(dest));
	}

	public void copyFolder(File src, File dest) {
		/** 源文件存在 **/
		if (src != null && src.exists()) {

			/** 递归拷贝 **/
			if (src.isDirectory()) {
				/** 判断目的文件存不存在 **/
				if (!dest.exists() || dest == null) {
					dest.mkdirs();
				}
				/** 获取文件 **/
				File[] files = src.listFiles();
				for (File f : files) {
					String k = f.getName();
					File file = new File(dest, k);
					copyFolder(f, file);
				}
			} else {
				copyFile(src, dest);
			}
		}

	}

	public void copyFile(String src, String dest) {
		copyFile(new File(src), new File(dest));
	}

	public void copyFile(File src, File dest) {
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new FileInputStream(src);
			out = new FileOutputStream(dest);
			byte[] b = new byte[1024];
			int length = in.read(b);
			while (length != -1) {
				out.write(b, 0, length);
				length = in.read(b);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
