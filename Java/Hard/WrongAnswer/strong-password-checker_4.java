class Solution {
    public int strongPasswordChecker(String password) {
        
        int n = password.length();
        int missingType = 3;
        if (password.matches(".*[a-z].*")) {
            missingType--;
        }
        if (password.matches(".*[A-Z].*")) {
            missingType--;
        }
        if (password.matches(".*[0-9].*")) {
            missingType--;
        }
        int change = 0;
        int one = 0;
        int two = 0;
        for (int i = 2, length = 0; i < n; i++) {
            if (password.charAt(i) == password.charAt(i - 1) && password.charAt(i - 1) == password.charAt(i - 2)) {
                length++;
            } else {
                if (length > 0) {
                    change += length / 3;
                    if (length % 3 == 0) {
                        one++;
                    } else if (length % 3 == 1) {
                        two++;
                    }
                }
                length = 0;
            }
        }
        if (n < 6) {
            return Math.max(missingType, 6 - n);
        } else if (n <= 20) {
            return Math.max(missingType, change);
        } else {
            int delete = n - 20;
            change -= Math.min(delete, one);
            change -= Math.min(Math.max(delete - one, 0), two * 2) / 2;
            change -= Math.max(delete - one - 2 * two, 0) / 3;
            return delete + Math.max(missingType, change);
        }
    }
}