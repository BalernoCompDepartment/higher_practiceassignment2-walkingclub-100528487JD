 import javax.swing.JOptionPane;
 import java.io.*;
 import java.util.Scanner;

class member{
String forename;
String surname;
double distance;
}
class Main {
  public static void main(String[] args) throws IOException{
    double [] noOfMarathons = new double [20];
    String content = "";
    Scanner fileScanner = null;
    double furthest = 0;
    int numberInArray = 20;
     member [] members = new member[numberInArray];
     String FileName = "results.txt";
     String fileName = "members.txt";

int Index = 0;

     try {
      fileScanner = new Scanner (new BufferedReader (new FileReader (fileName)));
      fileScanner.useDelimiter("[\\r\\n,]+");
      while (fileScanner.hasNext()) {
         members[Index] = new member();
         members[Index].forename = fileScanner.next();
         members[Index].surname = fileScanner.next();
         members[Index].distance = fileScanner.nextDouble();
         Index = Index + 1;
      }
      }

  catch (FileNotFoundException error) {
    System.out.println("File not found, fix the code an try again");
  }

   finally {
    if(fileScanner!=null) {
      fileScanner.close();
    }
     

     
        
        for(int index = 0; index < members.length; index ++){
          if(members[index].distance > furthest){
            furthest = members[index].distance;
            
          }
        }
        
       
         
        
          
          File writeFile = new File (FileName);
          

     if(!writeFile.exists()) {
       writeFile.createNewFile();
     }


     FileWriter fw = new FileWriter(writeFile.getAbsoluteFile());

     BufferedWriter bw = new BufferedWriter(fw);

     bw.write(content);

     bw.write("\n");
for(int INdex = 0; INdex < members.length; INdex ++){
  noOfMarathons[INdex] = members[INdex].distance/26.22;
}

     for (int loop = 0; loop < members.length; loop++){
      if(members[loop].distance > (furthest*0.7)){
         
       bw.write(members[loop].forename + " " + members[loop].surname + " " + (int)noOfMarathons[loop] + "\n");
      }
     }
     
     bw.newLine();

     bw.close();
         
    System.exit(0);
          
   
















    
  










    
  
}
}
}