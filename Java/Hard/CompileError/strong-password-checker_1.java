class Solution {
    public int strongPasswordChecker(String password) {
        
        int n = password.length();
        int missingType = 3;
        if (password.matches(".*[a-z].*")) missingType--;
        if (password.matches(".*[A-Z].*")) missingType--;
        if (password.matches(".*[0-9].*")) missingType--;
        
        int one = 0, two = 0;
        for (int i = 2, j = 0; i < n; i++, j++) {
            if (password.charAt(i) == password.charAt(i-1) && password.charAt(i-1) == password.charAt(i-2)) {
                int len = 2;
                while (i < n && password.charAt(i) == password.charAt(i-1)) {
                    i++;
                    len++;
                }
                if (len % 3 == 0) one++;
                if (len % 3 == 1) two++;
            }
        }
        
        if (n < 6) {
            return Math.max(missingType, 6 - n);
        } else if (n <= 20) {
            return Math.max(missingType, one);
        } else {
            int delete = n - 20;
            one -= Math.min(delete, one);
            two -= Math.min(Math.max(delete - one, 0), two * 2) / 2;
            three -= Math.max(delete - one - two * 2, 0) / 3;
            return delete + Math.max(missingType, one + two + three);
        }
    }
}