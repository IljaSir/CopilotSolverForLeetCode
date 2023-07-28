class Solution {
    public int myAtoi(String s) {
        
        int res = 0, i = 0, sign = 1, len = s.length();
        if (len == 0) return 0;
        while (i < len && s.charAt(i) == ' ') i++;
        if (i < len && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i++) == '-') ? -1 : 1;
        }
        while (i < len && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            if (res > Integer.MAX_VALUE / 10 ||
                (res == Integer.MAX_VALUE / 10 && s.charAt(i) - '0' > Integer.MAX_VALUE % 10)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (s.charAt(i++) - '0');
        }
        return res * sign;
    }
}