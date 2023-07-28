class Solution {
    public boolean strongPasswordCheckerII(String password) {
        
        boolean hasDigit = false;
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasSpecial = false;
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) hasDigit = true;
            if (Character.isUpperCase(c)) hasUpper = true;
            if (Character.isLowerCase(c)) hasLower = true;
            if (c == '!' || c == '@' || c == '#' || c == '$' || c == '%' || c == '^' || c == '&' || c == '*' || c == '(' || c == ')' || c == '-' || c == '+') hasSpecial = true;
        }
        if (password.length() < 8) return false;
        if (password.length() > 20) return false;
        if (hasDigit && hasUpper && hasLower && hasSpecial) return true;
        return false;
    }
}