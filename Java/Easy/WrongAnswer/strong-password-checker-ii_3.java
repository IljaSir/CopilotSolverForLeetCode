class Solution {
    public boolean strongPasswordCheckerII(String password) {
        
        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (c >= 'a' && c <= 'z') {
                hasLower = true;
            } else if (c >= 'A' && c <= 'Z') {
                hasUpper = true;
            } else if (c >= '0' && c <= '9') {
                hasDigit = true;
            } else if (c == '!' || c == '@' || c == '#' || c == '$' || c == '%' || c == '^' || c == '&' || c == '*' || c == '(' || c == ')' || c == '-' || c == '+') {
                hasSpecial = true;
            }
        }
        if (password.length() < 8) {
            return false;
        }
        if (!hasLower || !hasUpper || !hasDigit || !hasSpecial) {
            return false;
        }
        return true;
    }
}