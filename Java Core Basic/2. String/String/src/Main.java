public class Main {
    public static void main(String[] args) {
        // Sử dụng dấu nháy đơn
        String str = "Hello, World!";

        // Sử dụng từ khóa new
        String str1 = new String("Hello, World!");

        // Tạo từ mảng ký tự
        char[] chars = {'H', 'e', 'l', 'l', 'o'};
        String str2 = new String(chars);

        // Tạo từ byte
        byte[] bytes = {65, 66, 67};
        String str3 = new String(bytes);

        System.out.println(str);
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);

        // So sánh giá trị của 2 String
        String str4 = "Hello";
        String str5 = "Hello";
        boolean isEqual = str4.equals(str5);
        System.out.println(isEqual);

        // So sánh địa chỉ của 2 String
        String str6 = new String("Hello");
        String str7 = new String("Hello");
        boolean isSameReference = str1 == str2;
        System.out.println(isSameReference);


    }
}