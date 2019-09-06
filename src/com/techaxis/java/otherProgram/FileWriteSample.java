package com.techaxis.java.otherProgram;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FileWriteSample{
public static void main(String[] args) throws IOException{
	File f=new File("F:\\Java workspace\\FileData\\sample.txt");
	Writer w=new FileWriter(f);
	w.write("Hello World to file");
	w.close();
}
}
