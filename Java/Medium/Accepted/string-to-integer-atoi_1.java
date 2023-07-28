class Solution {
    public int myAtoi(String s) {
        
        int i = 0, n = s.length();
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        if (i == n) {
            return 0;
        }
        boolean negative = false;
        if (s.charAt(i) == '-') {
            negative = true;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }
        int ans = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 + digit;
            i++;
        }
        return negative ? -ans : ans;
    }
}