class Solution {
    public boolean strongPasswordCheckerII(String password) {
        
        int n = password.length();
        if (n < 8) return false;
        boolean hasLower = false, hasUpper = false, hasDigit = false;
        for (int i = 0; i < n; i++) {
            if (Character.isLowerCase(password.charAt(i))) hasLower = true;
            if (Character.isUpperCase(password.charAt(i))) hasUpper = true;
            if (Character.isDigit(password.charAt(i))) hasDigit = true;
        }
        if (!hasLower || !hasUpper || !hasDigit) return false;
        int count = 0;
        for (int i = 0; i < n - 2; i++) {
            if (password.charAt(i) == password.charAt(i + 1) && password.charAt(i) == password.charAt(i + 2)) {
                count++;
                i += 2;
            }
        }
        return count < 2;
    }
}