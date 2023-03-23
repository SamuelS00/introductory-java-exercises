package app;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import entities.Course;
import entities.Instructor;
import entities.Student;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Instructor instructor = new Instructor("Bob Brown");
		
		Course courseA = new Course("A", instructor);
		System.out.print("How many students for course A? ");
		int n = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			int code = sc.nextInt();
			sc.nextLine();
			Student student = new Student(code);
			courseA.enroll(student);
		}
		
		Course courseB = new Course("B", instructor);
		System.out.print("How many students for course B? ");
		n = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			int code = sc.nextInt();
			sc.nextLine();
			Student student = new Student(code);
			courseB.enroll(student);
		}
		
		Course courseC = new Course("C", instructor);
		System.out.print("How many students for course C? ");
		n = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			int code = sc.nextInt();
			sc.nextLine();
			Student student = new Student(code);
			courseC.enroll(student);
		}
		
		Set<Student> totalStudents = new HashSet<>(courseA.getStudents());
		totalStudents.addAll(courseB.getStudents());
		totalStudents.addAll(courseC.getStudents());
		
		System.out.println("TOTAL STUDENTS: " + totalStudents.size());
		
		sc.close();
	}

}
