class Solution {
    public int strongPasswordChecker(String password) {
        
        int n = password.length();
        int missingType = 3;
        if (password.matches(".*[a-z].*")) missingType--;
        if (password.matches(".*[A-Z].*")) missingType--;
        if (password.matches(".*[0-9].*")) missingType--;
        int res = 0;
        int one = 0, two = 0;
        for (int i = 2, len = 2; i < n; i++, len++) {
            if (password.charAt(i) == password.charAt(i - 1) && password.charAt(i - 1) == password.charAt(i - 2)) {
                if (len % 3 == 0) {
                    one++;
                    len = 0;
                }
            } else {
                len = 0;
            }
        }
        int totalReplace = 0;
        for (int i = 0, len = 0; i < n; i++, len++) {
            if (i < n - 1 && password.charAt(i) == password.charAt(i + 1)) {
                len++;
                if (len % 3 == 0) {
                    two++;
                    totalReplace++;
                    len = 0;
                }
            } else {
                len = 0;
            }
        }
        if (n < 6) {
            res = Math.max(missingType, 6 - n);
        } else if (n <= 20) {
            res = Math.max(missingType, one);
        } else {
            int delete = n - 20;
            res += delete;
            res += Math.max(missingType, one - delete);
            res += Math.max(0, two - delete);
        }
        return res;
    }
}