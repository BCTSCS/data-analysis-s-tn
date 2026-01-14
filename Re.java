public class Re {
    public static void main(String[] args) {
        String phone = "\\(?\\d{3}\\)?[-\\s\\.]?\\d{3}[-\\s\\.]?\\d{4}";
        String email = "[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}";
        String zip = "\\d{5}(-\\d{4})?";
        String ssn = "\\d{3}-?\\d{2}-?\\d{4}";
        
        String testPhone = "(123) 456-7890";
        String testEmail = "user@example.com";
        String testZip = "12345-6789";
        String testSSN = "123-45-6789";

        System.out.println(testPhone.matches(phone));
        System.out.println(testEmail.matches(email));
        System.out.println(testZip.matches(zip));
        System.out.println(testSSN.matches(ssn));
    }
}
