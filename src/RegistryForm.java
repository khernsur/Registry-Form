import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.time.LocalDate;
public class RegistryForm {

    public static void main(String[] args){
        Register register = new Register();
        Scanner scan = new Scanner(System.in);


        System.out.print("First Name: ");
        register.setFirstName(scan.nextLine());

        if(!Pattern.matches("^[a-zA-Z]*$",register.getFirstName())){
            System.out.println("First Name should not contain any numerals and special characters");
            return;
        }
        if(register.getFirstName().length() > 50){
            System.out.println("First Name should not be longer than 50 characters");
            return;
        }

        System.out.print("Last Name: ");
        register.setLastName(scan.nextLine());
        if(!Pattern.matches("^[a-zA-Z]*$",register.getLastName())){
            System.out.print("Last Name should not contain any numerical and special characters");
            return;
        }

        if(register.getLastName().length() > 50){
            System.out.print("Last Name should not be longer than 50 characters");
            return;
        }

        System.out.print("Birthday (yyyy-mm-dd): ");
        register.setBirthday(scan.next());

        LocalDate birthdayDate;

        try{
            birthdayDate = LocalDate.parse(register.getBirthday());
        }catch(Exception e){
            System.out.println("Birthday should be in the format of yyyy/mm/dd. ");
            return;
        }


        if(LocalDate.now().getYear() - birthdayDate.getYear() < 18 || LocalDate.now().getYear() - birthdayDate.getYear() > 25){
            System.out.println("Acceptable age range for college is between 18 and 25.");
            return;
        }



        System.out.print("Course: ");
        register.setCourse(scan.next());

        if(Pattern.matches(".*\\d+.*", register.getCourse())){
            System.out.println("Course should not contain numerals");
            return;
        }

        if(register.getCourse().length() > 50){
            System.out.println("Course should not be longer than 50 characters");
            return;
        }

        System.out.print("Email Address: ");
        register.setEmail(scan.next());

        if(!Pattern.matches("^[A-Za-z0-9+_.-]+@(.+)$", register.getEmail())){
            System.out.println("Email Address should be in correct format");
           return;
        }


        String yearToDate = Integer.toString(LocalDate.now().getYear());
        String birthDateDay = String.format("%02d%02d", birthdayDate.getMonthValue(), birthdayDate.getDayOfMonth());
        String studentNumber = yearToDate + "-" + birthDateDay + "-" + register.getLastName().charAt(0);
        System.out.println("Student Number: " + studentNumber);
    }

}
