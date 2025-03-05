import java.util.*;

//ADD STUDENT
//REMOVE STUDENT
//MODIFY STUDENT
//DISPLAYING STUDENTS
//GET DETAILS OF A SPECIFIC STUDENT

public class StudentManagementSystem {

    Scanner sc = new Scanner(System.in);
    HashMap<String, ArrayList<String>> studentDetails = new HashMap<>();

    //Add Student
    public void addStudent(){

        System.out.println("Enter the Name:");
        String name = sc.next();

        System.out.println("Enter the Roll No:");
        String roll = sc.next();

        System.out.println("Enter the Email:");
        String email = sc.next();

        System.out.println("Enter the Phone Number:");
        String ph = sc.next();

        System.out.println("Enter the Course:");
        String course = sc.next();

        ArrayList<String> studentList = new ArrayList<>();

        studentList.add(roll);
        studentList.add(email);
        studentList.add(ph);
        studentList.add(course);

        studentDetails.put(name, studentList);

    }

    //Display Student List
    public void displayAll(){

        Set<HashMap.Entry<String, ArrayList<String>>> entrySet = studentDetails.entrySet();
        for (Map.Entry<String, ArrayList<String>>entry:entrySet){
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
    }

    //Display a specific student
    public void displayOne(){

        System.out.println("You need the details of which student?");
        String name=sc.next();
        if (studentDetails.containsKey(name)){
            System.out.println(studentDetails.get(name));
        }
        else{
            System.out.println("Student not found");
        }
    }

    //Remove student
    public void remove(){
        System.out.println("Which student you want to remove?");
        String name = sc.next();
        if(studentDetails.containsKey(name)){

            studentDetails.remove(name);
            System.out.println("Student removed successfully!");
            displayAll();

        }
        else {
            System.out.println("Student not found");
        }
    }

    //Modify student
    public void modify(){

        System.out.println("Which student details you want to modify?");
        String name = sc.next();

        if(studentDetails.containsKey(name)){

            ArrayList<String> studentList = studentDetails.get(name);

            System.out.println("What do you want to change?");
            System.out.println("1. Phone Number");
            System.out.println("2. Email");

            int choice= sc.nextInt();

            if (choice==1){
                System.out.println("Enter the new Phone Number:");
                String newNo = sc.next();
                studentList.set(2, newNo);
            }
            if (choice==2){
                System.out.println("Enter the new Email:");
                String newMail = sc.next();
                studentList.set(1, newMail);
            }
            studentDetails.remove(name);
            studentDetails.put(name, studentList);
            System.out.println("Details updated successfully");

        }
        else {
            System.out.println("Student not found");
        }
    }

    public void choose(){
        System.out.println("Hello! Welcome to Student Management System by Shri!");
        System.out.println("Available options:");
        System.out.println("1. Add student");
        System.out.println("2. Remove student");
        System.out.println("3. Modify student");
        System.out.println("4. Display students");
        System.out.println("5. Get details of a specific student");
        int choice= sc.nextInt();
        if(choice==1){
            addStudent();
        }
        else if(choice==2){
            remove();
        }
        else if (choice==3){
            modify();
        }
        else if(choice==4){
            displayAll();
        }
        else if (choice==5){
            displayOne();
        }
        else{
            System.out.println("Please enter a valid choice");
        }
    }

    public static void main(String[] args) {

        StudentManagementSystem sms = new StudentManagementSystem();
        while(true){
            sms.choose();
        }
    }
}