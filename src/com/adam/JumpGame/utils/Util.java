package com.adam.JumpGame.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Util {

	public static String loadFileAsString(String path) {
		StringBuilder sb = new StringBuilder();//StringBuilder allows you to add to a string
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			//String line;
			while((br.readLine()) != null)
				sb.append(br.readLine() + "\n");//adding each new line to the String and then creating a new line with "\n"
				
			br.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return sb.toString();
		
	}
	
	public static int stringToInt(String number) {
		try {
			return Integer.parseInt(number);
		}catch(NumberFormatException e) {
			e.printStackTrace();
			return 0;
		}
	}
}
