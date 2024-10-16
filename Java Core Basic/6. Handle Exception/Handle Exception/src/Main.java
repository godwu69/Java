// throw

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            throw new Exception("This is 1 exception");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}

// throws

//public class Main {
//    public static void main(String[] args) {
//        try {
//            methodThatThrows();
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
//    }
//
//    public static void methodThatThrows() throws Exception {
//        throw new Exception("Exception throws by method");
//    }
//}

// Checked Exception

//public class Main {
//    public static void main(String[] args) {
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader("noneFile.txt"));
//            System.out.println(reader.readLine());
//        } catch (IOException ex) {
//            System.out.println("Exception found: " + ex.getMessage());
//        }
//    }
//}

// Unchecked Exception

//public class Main {
//    public static void main(String[] args) {
//        try {
//            int[] arr = new int[5];
//            System.out.println(arr[10]);
//        } catch (ArrayIndexOutOfBoundsException ex) {
//            System.out.println("Exception found: " + ex.getMessage());
//        }
//    }
//}

// try-catch

//public class Main {
//    public static void main(String[] args) {
//        try {
//            File file = new File("noneFile.txt");
//            Scanner scanner = new Scanner(file);
//        } catch (FileNotFoundException ex) {
//            System.out.println("File not found: " + ex.getMessage());
//        }
//    }
//}

// try-with-resources

//public class Main {
//    public static void main(String[] args) {
//        try (BufferedReader reader = new BufferedReader(new FileReader("noneFile.txt"))){
//            String line = reader.readLine();
//            System.out.println(line);
//        } catch (IOException ex) {
//            System.out.println("Exception found:" + ex.getMessage());
//        }
//    }
//}

// Custom Exception

//public class Main {
//    public static void main(String[] args) {
//        try {
//            validateAge(15);
//        } catch (MyCustomException ex) {
//            System.out.println("Exception: " + ex.getMessage());
//        }
//    }
//
//    public static void validateAge(int age) throws MyCustomException {
//        if (age < 18) {
//            throw new MyCustomException("Age must be at least 18");
//        }
//        System.out.println("Valid age: " + age);
//    }
//}