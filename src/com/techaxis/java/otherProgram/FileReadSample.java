package com.techaxis.java.otherProgram;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class FileReadSample {
public static void main(String[] args) throws IOException {
	String line=null;
	File f=new File("F:\\Java workspace\\FileData\\sample.txt");
	Reader r=new FileReader(f);
	BufferedReader br=new BufferedReader(r);
	line=br.readLine();
	System.out.println(line);
	br.close();
	
}
}
