class Solution {
    public boolean strongPasswordCheckerII(String password) {
        
        int len = password.length();
        if (len < 8) {
            return false;
        }
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpper = true;
            } else if (Character.isLowerCase(c)) {
                hasLower = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else {
                hasSpecial = true;
            }
        }
        int count = 0;
        if (hasUpper) count++;
        if (hasLower) count++;
        if (hasDigit) count++;
        if (hasSpecial) count++;
        if (count == 4) return true;
        if (count == 3) {
            if (len >= 8) {
                return true;
            } else {
                return false;
            }
        }
        if (count == 2) {
            if (len >= 10) {
                return true;
            } else {
                return false;
            }
        }
        if (count == 1) {
            if (len >= 12) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}