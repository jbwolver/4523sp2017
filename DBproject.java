
import java.io.IOException;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author adonis
 */
public class DBproject {
    
    //class intances 
    private DB_connector jdbc;
    private final String username = "ejsanche";              // Change to your own username
    private final String mysqlPassword = "21adonis94";    // Change to your own mysql Password
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException{
        
        
        // TODO code application logic here
        DBproject obj = new DBproject();
        obj.menu(args);
        
    }
    
    public DBproject()throws SQLException{
        jdbc = new DB_connector();
        jdbc.connect(username, mysqlPassword);
    }
    
    public void menu(String [] args)throws SQLException{
        int op;
        op = Integer.parseInt(args[0]);
        switch(op){
            case 1:
                //called function 1
                func1Query(args);
                break;
            case 2:
                //Called function 2
                func2Query(args);
                break;
            case 3: 
                func3Query(args);
                break;
            default:
                    break;
        }
        jdbc.disConnect();
       
    }
    
    //Add a student to the Student table
    public void func1Query(String [] args)throws SQLException{
        String verifyquery = "SELECT * FROM Student s where s.studentId ='"+args[1]+"';";
        int verificationResult = jdbc.verifyQuery(verifyquery);
        
        if(verificationResult == 0){
            System.out.println("The student with id \" "+args[1]+" \" already exist in our data base");
            return;
        }
        
        String query = "INSERT INTO Student values('" + args[1] + "','" + args[2] + "','" + args[3] + "');";
        jdbc.update(query);
        System.out.println("New record added succesfully");
    }
    //Add a course to the Course table
     public void func2Query(String [] args)throws SQLException{
        String verifyquery = "SELECT * FROM Course c WHERE c.deptCode = '"+args[1]+"' AND c.courseNum = '"+args[2]+"';";
        
        int verificationResult = jdbc.verifyQuery(verifyquery);
        
        if(verificationResult == 0){
            System.out.println("The course \" " +args[1]+ " " +args[2]+" \" already exist in our data base");
            return;
        }
        String query = "INSERT INTO Course values('" + args[1] + "','" + args[2] + "','" + args[3] + "','" + args[4] +"');";
        jdbc.update(query);
        System.out.println("New record added succesfully");
        
    }
    //Add an application to the Enrollment table
    public void func3Query(String [] args)throws SQLException{
        
        //verify if already register
        String verifyquery ="SELECT * FROM Enrollment e WHERE e.studentId ='"+args[1]+"' AND e.deptCode = '"+args[2]+"' AND e.courseNum = '" +args[3]+"';";
        int verificationResult = jdbc.verifyQuery(verifyquery);
         if(verificationResult == 0){
            System.out.println("This student with id \" "+args[1]+" \" is already enroll in the course \" " +args[2]+ " " +args[3]+" \"");
            return;
        }
        //veryfy if couse exists
        verifyquery = "SELECT * FROM Course c WHERE c.deptCode = '"+args[2]+"' AND c.courseNum = '"+args[3]+"';";
        verificationResult = jdbc.verifyQuery(verifyquery);
         if(verificationResult == 1){
            System.out.println("Sorry but the course \" " +args[2]+ " " +args[3]+" \" does not exist in our records");
            return;
        }
        //veryfy if id exist
        verifyquery = "SELECT * FROM Student s where s.studentId ='"+args[1]+"';";
        verificationResult = jdbc.verifyQuery(verifyquery);
         if(verificationResult == 1){
            System.out.println("Sorry but the student with Id \" "+args[1]+" \" does not exist in our records");
            return;
        }
        String query = "INSERT INTO Enrollment values('" + args[1] + "','" + args[2] + "','" + args[3] + "');";
        jdbc.update(query);
        System.out.println("New record added succesfully");
        
    }
    
}

