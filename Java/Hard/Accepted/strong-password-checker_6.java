class Solution {
    public int strongPasswordChecker(String password) {
        
        int n = password.length();
        int[] arr = new int[n];
        int l = 0, u = 0, d = 0;
        for (int i = 0; i < n; i++) {
            char c = password.charAt(i);
            if (Character.isLowerCase(c)) {
                l = 1;
            } else if (Character.isUpperCase(c)) {
                u = 1;
            } else if (Character.isDigit(c)) {
                d = 1;
            }
        }
        int missing = 3 - (l + u + d);
        if (n < 6) {
            return Math.max(missing, 6 - n);
        }
        int change = 0;
        int one = 0, two = 0;
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j < n && password.charAt(j) == password.charAt(i)) {
                j++;
            }
            int len = j - i;
            if (len >= 3) {
                arr[i] = len;
                change += len / 3;
                if (len % 3 == 0) {
                    one++;
                } else if (len % 3 == 1) {
                    two++;
                }
            }
            i = j - 1;
        }
        if (n <= 20) {
            return Math.max(missing, change);
        }
        int del = n - 20;
        change -= Math.min(del, one);
        change -= Math.min(Math.max(del - one, 0), two * 2) / 2;
        change -= Math.max(del - one - 2 * two, 0) / 3;
        return del + Math.max(missing, change);
    }
}