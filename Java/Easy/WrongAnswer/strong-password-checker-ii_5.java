class Solution {
    public boolean strongPasswordCheckerII(String password) {
        
        if (password.length() < 8) return false;
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) hasUpper = true;
            if (Character.isLowerCase(password.charAt(i))) hasLower = true;
            if (Character.isDigit(password.charAt(i))) hasDigit = true;
            if (password.charAt(i) == '!' || password.charAt(i) == '@' || password.charAt(i) == '#' || password.charAt(i) == '$' || password.charAt(i) == '%' || password.charAt(i) == '^' || password.charAt(i) == '&' || password.charAt(i) == '*' || password.charAt(i) == '(' || password.charAt(i) == ')' || password.charAt(i) == '-' || password.charAt(i) == '+') hasSpecial = true;
        }
        return hasUpper && hasLower && hasDigit && hasSpecial;
    }
}