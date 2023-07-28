class Solution {
    public boolean possiblyEquals(String s1, String s2) {
        
        if (s1.length() == 0 && s2.length() == 0) {
            return true;
        }
        if (s1.length() == 0 || s2.length() == 0) {
            return false;
        }
        int i = 0;
        int j = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else if (Character.isDigit(s1.charAt(i)) && Character.isDigit(s2.charAt(j))) {
                int num1 = 0;
                int num2 = 0;
                while (i < s1.length() && Character.isDigit(s1.charAt(i))) {
                    num1 = num1 * 10 + (s1.charAt(i) - '0');
                    i++;
                }
                while (j < s2.length() && Character.isDigit(s2.charAt(j))) {
                    num2 = num2 * 10 + (s2.charAt(j) - '0');
                    j++;
                }
                if (num1 != num2) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return i == s1.length() && j == s2.length();
    }
}