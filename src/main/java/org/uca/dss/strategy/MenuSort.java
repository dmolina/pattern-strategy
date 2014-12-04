package org.uca.dss.strategy;

import java.io.Console;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * This class ask some numbers, them they are
 * sorted, and the results is printed
 * @author daniel
 *
 */
public class MenuSort {
	private Scanner console;
	public MenuSort() {
		console = new Scanner(System.in);
	}
	/**
	 * Show the message
	 */
	private void showMessage() {
		PrintStream out = System.out;
		
		System.out.println("***************");
		System.out.println("* Sort Number *");
		System.out.println("***************");
		
		System.out.print("Introduce several numbers (separed by spaces): ");
	}	
	public ListNumbers readLineNumber() {
		ListNumbers list = new ListNumbers();
		boolean quit = false;		
		do {
			showMessage();
			String input = console.nextLine();
			
			quit = input.equalsIgnoreCase("q");
			
			if (!quit){
				list = new ListNumbers(input);		
			}
		} while (!quit && list.isEmpty());
		
		return list;
	}
	
	public void run() {
		String input;
		ListNumbers listnumbers = readLineNumber();	
		
		if  (listnumbers.isEmpty()) {
			return;
		}
		
		showOption();
		do {
			input = console.nextLine();
		} while (!input.equalsIgnoreCase("b"));
		
		System.out.println("Before sort: ");
		System.out.println(listnumbers.toString());
		listnumbers.sort();
		System.out.println("After sort: ");
		System.out.println(listnumbers.toString());
	}


	private void showOption() {
		PrintStream out = System.out;
		out.println("Types of sort: ");
		out.println("[b] bubble sort   ");
		out.print("Your option: ");
	}
}
