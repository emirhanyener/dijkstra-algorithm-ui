package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
	private FileManager() {
		
	}
	
	public static String folderName = ".\\data\\";
	
	public static void Write(String fileName, String value) {
		try {
			FileWriter writer = new FileWriter(folderName + fileName);
			writer.write(value);
			writer.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String Read(String fileName) {
		try {
			FileReader reader = new FileReader(folderName + fileName);
			String temp = "";
			int c = 0;
			try {
				while((c = reader.read()) != -1) {
					temp += (char)c;
				}
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
			return temp;
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public static boolean isExists(String fileName) {
		File file = new File(folderName + fileName);
		if(file.exists())
			return true;
		return false;
	}
}
