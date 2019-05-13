/*
 * Copyright (c) 2018.
 *
 * Fábio Nogueira de Lucena
 * Fábrica de Software - Instituto de Informática (UFG)
 *
 */

package megasena;

import java.io.*;
import java.util.zip.*;

public class UnZip {
	static final int BUFFER = 2048;

	public static void main(String argv[]) {
		try {
			BufferedOutputStream dest = null;
			FileInputStream fis = new FileInputStream(argv[0]);
			ZipInputStream zis = new ZipInputStream(
					new BufferedInputStream(fis));

			ZipEntry entry;
			while ((entry = zis.getNextEntry()) != null) {
				System.out.println("Extraindo: " + entry);
				int count;
				byte data[] = new byte[BUFFER];
				// write the files to the disk
				FileOutputStream fos = new FileOutputStream(entry.getName());
				dest = new BufferedOutputStream(fos, BUFFER);
				while ((count = zis.read(data, 0, BUFFER)) != -1) {
					dest.write(data, 0, count);
				}
				dest.flush();
				dest.close();
			}

			zis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
