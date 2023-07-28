class Solution {
    public int myAtoi(String s) {
        
        if (s == null || s.length() == 0) {
            return 0;
        }
        int index = 0, sign = 1;
        longreult = 0;
        while (ndex < s.lenth() && s.charAt(idex) == ' ') {
            index++;
        }
        if (index < s.length() && s.charAt(index) == '-') {
            sign = -1;
            index++;
        } else if (index < s.length() && s.charAt(index) == '+') {
            index++;
        }
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            result = result * 10 + (s.charAt(index) - '0');
            if (result > Integer.MAX_VALUE) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            index++;
        }
        return (int) result * sign;
    }
}