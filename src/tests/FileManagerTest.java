package tests;
import utils.FileManager;

public class FileManagerTest {
	private FileManagerTest() {
		
	}

	public static void FileWriteTest() {
		String testName = "file write test";
		String fileName = "test.txt";
		String value = "test";
		FileManager.Write(fileName, value);
		System.out.println(FileManager.Read(fileName));
		if(FileManager.Read(fileName).equals(value))
			System.out.println("[V] " + testName + " success");
		else
			System.out.println("[X] " + testName + " fail");
	}
}