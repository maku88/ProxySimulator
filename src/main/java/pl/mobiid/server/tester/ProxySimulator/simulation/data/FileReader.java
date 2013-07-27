package pl.mobiid.server.tester.ProxySimulator.simulation.data;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileReader implements DataReader {

    private String filePath = "";

    public FileReader(String filePath) {
        this.filePath = filePath;
    }

	
	@Override
    public List<Tag> read() {
        List<Tag> tagList = new ArrayList<Tag>();
	    try{
			  FileInputStream fstream = new FileInputStream(filePath);
			  // Get the object of DataInputStream
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String strLine;
			  while ((strLine = br.readLine()) != null)   {
				  String[] s = strLine.split(";");
				  tagList.add(new Tag(s[0], s[1],0));
			  }
			  in.close();
			  
			  return tagList;
		}catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
			  return tagList;
		}
		
	}
	
	
}
