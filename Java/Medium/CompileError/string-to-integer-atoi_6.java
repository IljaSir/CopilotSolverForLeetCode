class Solution {
    public int myAtoi(String s) {
        
        if (s == null || s.length() == 0) {
            return 0;
        }
        int i = 0;
        int sign = 1;
        int result = 0;
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        if (i < s.length() && s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (i < s.length() && s.charAt(i) == '+') {
            i++; sign;
    }
}