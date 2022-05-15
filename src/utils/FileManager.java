package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
	private FileManager() {
		
	}
	
	public static void Write(String fileName, String value) {
		try {
			FileWriter writer = new FileWriter(".\\data\\" + fileName);
			writer.write(value);
			writer.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String Read(String fileName) {
		try {
			FileReader reader = new FileReader(".\\data\\" + fileName);
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
}
