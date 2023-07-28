class Solution {
    public int strongPasswordChecker(String password) {
        
        int n = password.length();
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        int[] count = new int[3];
        int total = 0;
        int i = 0;
        while (i < n) {
            char c = password.charAt(i);
            if (Character.isUpperCase(c)) {
                hasUpper = true;
            } else if (Character.isLowerCase(c)) {
                hasLower = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            }
            int j = i;
            while (i < n && password.charAt(i) == c) {
                i++;
            }
            int len = i - j;
            if (len > 2) {
                int k = len / 3;
                total += k;
                count[k - 1]++;
            }
        }
        int missing = (hasUpper ? 0 : 1) + (hasLower ? 0 : 1) + (hasDigit ? 0 : 1);
        if (n < 6) {
            return Math.max(missing, 6 - n);
        } else if (n <= 20) {
            return Math.max(missing, total);
        }
        int delete = n - 20;
        total -= Math.min(delete, count[0]);
        total -= Math.min(Math.max(delete - count[0], 0), count[1] * 2) / 2;
        total -= Math.min(Math.max(delete - count[0] - 2 * count[1], 0), count[2] * 3) / 3;
        return delete + Math.max(missing, total);
    }
}