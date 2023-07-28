class Solution {
    public boolean possiblyEquals(String s1, String s2) {
        
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 == 0 || len2 == 0) {
            return len1 == len2;
        }
        if (s1.charAt(0) == s2.charAt(0)) {
            return possiblyEquals(s1.substring(1), s2.substring(1));
        }
        if (s1.charAt(0) > '9' || s2.charAt(0) > '9') {
            return false;
        }
        int i = 1;
        while (i < len1 && s1.charAt(i) <= '9') {
            i++;
        }
        int j = 1;
        while (j < len2 && s2.charAt(j) <= '9') {
            j++;
        }
        String num1 = s1.substring(0, i);
        String num2 = s2.substring(0, j);
        if (num1.length() > 1 && num1.charAt(0) == '0' || num2.length() > 1 && num2.charAt(0) == '0') {
            return false;
        }
        int num1Val = Integer.parseInt(num1);
        int num2Val = Integer.parseInt(num2);
        if (num1Val == 0 && num2Val == 0) {
            return false;
        }
        if (num1Val != 0 && num1Val < num2Val) {
            return false;
        }
        if (num2Val != 0 && num2Val < num1Val) {
            return false;
        }
        if (num1Val == num2Val) {
            return possiblyEquals(s1.substring(i), s2.substring(j));
        }
        if (num1Val == 0) {
            return possiblyEquals(s1.substring(i), s2);
        }
        if (num2Val == 0) {
            return possiblyEquals(s1, s2.substring(j));
        }
        return false;
    }
}