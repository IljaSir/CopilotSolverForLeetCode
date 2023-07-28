class Solution {
    public int myAtoi(String s) {
        
        int i = 0;
        int sign = 1;
        int res = 0;
        int n = s.length();
        while (i < n && s.charAt(i) == ' ')
            i++;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-'))
            sign = s.charAt(i++) == '-' ? -1 : 1;
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i++) - '0';
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10))
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + digit;
        }
        return res * sign;
    }
}