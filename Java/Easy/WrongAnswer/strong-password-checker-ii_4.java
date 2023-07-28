class Solution {
    public boolean strongPasswordCheckerII(String password) {
        
        int n = password.length();
        if (n < 8) {
            return false;
        }
        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;
        for (int i = 0; i < n; i++) {
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
        int count = 0;
        if (hasLower) {
            count++;
        }
        if (hasUpper) {
            count++;
        }
        if (hasDigit) {
            count++;
        }
        if (hasSpecial) {
            count++;
        }
        if (count >= 3) {
            return true;
        }
        if (count == 2) {
            if (n >= 10) {
                return true;
            }
            int i = 0;
            while (i < n) {
                char c = password.charAt(i);
                int j = i;
                while (j < n && password.charAt(j) == c) {
                    j++;
                }
                if (j - i >= 3) {
                    return true;
                }
                i = j;
            }
            return false;
        }
        return n >= 6;
    }
}