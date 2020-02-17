
// To run this code we need the JSON Simpler jar file to covert object to JSON Object,  http://www.java2s.com/Code/Jar/j/Downloadjsonsimple11bundlejar.htm
// I have modified the json file little bit
// With this idea I made this project http://ide.immohanbera.codes/


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class linux
{
    public static void main(String[] args) throws IOException, ParseException
    {
        // first initialize the parser
        JSONParser jsonParser=new JSONParser();

        // parsing the json file data to the object
        Object obj=jsonParser.parse(new FileReader("/home/mrcoderider/IdeaProjects/firstJava/src/package.json"));

        // converting to jsonObject
        JSONObject jsonObject=(JSONObject)(obj);

        // then get the dependencies array from the the json file, please check the json file
        JSONArray dependencies = (JSONArray)jsonObject.get("Dependencies");

        // visiting all the dependencies
        for(Object keys : dependencies)
        {
            // getting the dependency name and convert to string object
            String dependencyName=keys.toString();

            // Here is the processBuilder which will run the installation commands internally without opening the terminal.
            ProcessBuilder processBuilderL=new ProcessBuilder();

            //Here is the installation commands stored inside the String array
            String[] commandToInstall = {"pip", "install",dependencyName};

            // giving the command to processBuilder
            processBuilderL.command(commandToInstall);

            // Now the command will be executed from here
            Process process=processBuilderL.start();

            // initializing the status code
            int statusCode = 0;
            try {
                // waiting for the process to complete the execution of the command
                statusCode=process.waitFor();
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            // checking the statusCode if 0 then successful
            if(statusCode==0)
            {
                System.out.println(dependencyName+" has been installed successfully....");
            }
            else
            {
                // if the statusCode is not 0 then there must be some errors which will be stored in error.txt file,
                // later we can display the error
                System.out.println(dependencyName+" has not been installed because of some errors....");
                processBuilderL.redirectError(new File("/home/mrcoderider/IdeaProjects/firstJava/src/error.txt"));
            }
        }


    }
}
