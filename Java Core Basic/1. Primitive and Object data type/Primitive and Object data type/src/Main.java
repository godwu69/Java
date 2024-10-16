public class Main {
    public static void main(String[] args) {
        int num = 10;
        Integer objNum = num;  // Autoboxing

        Integer objNum2 = Integer.valueOf(10);
        int num2 = objNum2;    //Unboxing

        System.out.println(num);
        System.out.println(objNum);
        System.out.println(num2);
        System.out.println(objNum2);


        int num3 = 10; // Kiểu dữ liệu nguyên thủy
        Integer objNum3 = 10; // object

        if (num3 == objNum3) {
            System.out.println("num3 and objNum3 are equal ");
        } else {
            System.out.println("num3 and objNum3 are not equal ");
        }


        int num4 = 0; //Khởi tạo kiểu dữ liệu nguyên thủy
        Integer objNum4 = null; //Khởi tâọ kiểu dữ liệu object

        System.out.println(num4);
        System.out.println(objNum4);
    }
}