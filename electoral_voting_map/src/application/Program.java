package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("what is the input file path? ");
        String pathIn = sc.next();
        
		try (BufferedReader br = new BufferedReader(new FileReader(pathIn))) {
            String line = br.readLine();
            Map<String, Integer> candidates = new LinkedHashMap<>();
            
            while (line != null) {
            	String[] fields = line.split(",");
            	String name = fields[0];
            	Integer votes = Integer.parseInt(fields[1]);
            	
            	if (candidates.containsKey(name)) {
            		candidates.put(name, candidates.get(name) + votes);
            	} else {
            		candidates.put(name, votes);
                }
            	
                line = br.readLine();
            }
            
    		for (String key: candidates.keySet()){
    			System.out.println(key+ " = " + candidates.get(key));
    		} 
           

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
	}

}
