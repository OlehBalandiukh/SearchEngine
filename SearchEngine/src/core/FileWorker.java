package core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


public class FileWorker {
 
	/**
	Update directory
	@param
	@return void
	*/
    public  void updateDir (String startDir) {
        File dir = new File(startDir);
        if(dir.isDirectory())
        {
            for(File item : dir.listFiles()){
                 if(item.isFile()){
                	 System.out.println(item.getName() + "\tфайл");
                	 print(validate(readFile(item)));
                 }
                 else{
                	 updateDir(item.getPath());
                 }
             }
        }
    }
    
	/**
	Read file using pass
	@param
	@return String, file content
	*/
	public String readFile(File file) {
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(file.getPath()))) {
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}

		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IOException");
			e.printStackTrace();
		}

		return sb.toString();
	}
	
	/**
	Validate text
	@param
	@return String array, array of unique words
	*/
	public String[] validate(String input) {
		input = input.toLowerCase().replaceAll("[']", "");
		input = input.toLowerCase().replaceAll("[^\\w]", " ");
		String[] output = input.split("\\s+");
		return output;

	}
	
	public void print(String[] splitted) {
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		for (int i = 0; i < splitted.length; i++) {
			if (!hm.containsKey(splitted[i])) {
				hm.put(splitted[i], 1);
			} else {
				hm.put(splitted[i], (Integer) hm.get(splitted[i]) + 1);
			}
		}
		
		for(Map.Entry<String, Integer> entry : hm.entrySet()) {
		    String key = entry.getKey();
		    Integer value = entry.getValue();

       	 
       	try(FileWriter fw = new FileWriter("D:\\Root\\Log.log", true);
       		    BufferedWriter bw = new BufferedWriter(fw);
       		    PrintWriter out = new PrintWriter(bw))
       		{
       		    out.println(key + " - " + value);
       		} catch (IOException e) {
       		    //exception handling left as an exercise for the reader
       		}
		    //System.out.println(key + " - " + value);
		}

	}
}