package MessyCodeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Test {

	public void a(String path) {
		byte[] bytes = new byte[10];
		OutputStream os = null;
		InputStream is = null;
		try {
			File f = new File(path);
			is = new FileInputStream(f);
			os = new FileOutputStream(f);
			int length = is.read(bytes);
			for (int i = 0; i < bytes.length; i++) {
				System.out.println(new String(bytes, 0, length));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void b() {
		String str = "ÖÐ¹úhello";

	}

	public static void main(String[] args) {
		Test test = new Test();
		test.a("test");
	}
}
