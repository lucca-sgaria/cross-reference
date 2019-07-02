package br.com.ucs.referencia.cruzada.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class TextUtil {

	public static File readFile() {
		JFileChooser fc = new JFileChooser();
		File file = null;

		int returnVal = fc.showOpenDialog(null);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			file = fc.getSelectedFile();
			System.out.println("aberto arquivo : " + file.getName());
		}
		return file;
	}

	public static String getTitle(File file) {
		Scanner sc = getScanner(file);
		String title = sc.nextLine();
		System.out.println("pegou titulo : " + title);
		return title;
	}

	private static Scanner getScanner(File file) {
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return sc;
	}

	public static String getContent(File file) {
		Scanner sc = getScanner(file);
		String content = "";
		int i = 0;
		while (sc.hasNextLine()) {
			if (i > 0) {
				content += sc.nextLine();
			} else {
				sc.nextLine();
				i++;
			}
		}

		System.out.println("content :" + content);
		return content;
	}

	public static String toLowerCase(String text) {
		return text.toLowerCase();
	}
	
	public static String[] getWords(String content) {
		String[] words = content.split("\\W+");
		
		return words;
	}

}
