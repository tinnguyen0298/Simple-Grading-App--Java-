package finalExam;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;


/**
 * @author tinng
 * Student: Trung Tin Nguyen
 * Instructor: Chander Thangavelu
 * This assignment is final project.
 */
public class FinalProject {

	public static void main(String[] args) {
		//read a file 
		//File name: grades_1H1.txt
		try (Scanner input = new Scanner(System.in)) {
			System.out.print("Enter the file name: ");
			String fileName = input.next();
			try {
				Scanner read = new Scanner(new File(fileName));
				//generate an array of grades 
				ArrayList<Double> grade = new ArrayList<>();
				
				while (read.hasNext()) {
					String line = read.nextLine();
					grade.add(Double.parseDouble(line));
					
				}
				//number of grades
				System.out.println("\nNumber of grades: " + grade.size());
				
				//invoke calculate mean
				System.out.println("Mean: " + calculateMean(grade));
				
				//invoke calculate standard deviation
				System.out.printf("Standard Deviation: %.4f", calculateStandardDeviation(grade));
				
				//create linked list
				LinkedList<Object> scoreGradeList = new LinkedList<>();
				
				//add Node to linked list
				for (int i = 0; i < grade.size(); i++) {
					Node node = new Node(grade.get(i), calculateLetterGrade(grade, grade.get(i)));
					scoreGradeList.add(node);
				}
				
				//print out the list
				printList(scoreGradeList);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	/**
	 * @param list
	 * @return mean
	 */
	public static double calculateMean(ArrayList<Double> list) {
		double sum = 0;
		for (int i = 0; i <list.size();i++) {
			sum+=list.get(i);
		}
		return sum/list.size();
	}
	
	/**
	 * @param list
	 * @return standard deviation
	 */
	public static double calculateStandardDeviation(ArrayList<Double> list) {
		double mean = calculateMean(list);
		double numerator = 0;
		double denominator;
		
		//calculate numerator 
		for (int i=0; i<list.size();i++) {
			numerator += (list.get(i)-mean)*(list.get(i)-mean);
		}
		//calculate denominator
		denominator = (list.size()-1);
		
		return Math.sqrt((numerator/denominator));
	}
	
	/**
	 * @param list
	 * @param grade
	 * @return letter grade
	 */
	public static String calculateLetterGrade(ArrayList<Double> list, double grade) {
		double mean = calculateMean(list);
		double sd = calculateStandardDeviation(list);
		
		String letterGrade = null;
		
		if (grade >= (mean +1.5*sd) ) {
			letterGrade = "A";
		}
		else if ((mean + 0.5*sd)<= grade && grade <=(mean + 1.5*sd)){
			letterGrade = "B";
		}
		else if ((mean - 0.5*sd)<= grade && grade <=(mean + 0.5*sd)) {
			letterGrade = "C";
		}
		else if((mean - 1.5*sd)<= grade && grade <=(mean - 0.5*sd)){
			letterGrade = "D";
		}
		else if (grade < (mean - 1.5*sd)){
			letterGrade = "F";
		}
		return letterGrade;
	}
	
	/**
	 * @param list
	 * @return print format 
	 */
	public static void printList(LinkedList<Object> list) {
		System.out.printf("%2s %7s %3s %n", "\n ", "Score ", " Grade");
		for (int i = 0; i < list.size(); i++) {
			System.out.printf("%2s %s %n", (i+1), list.get(i));
		}
		return;
	}
}

	
