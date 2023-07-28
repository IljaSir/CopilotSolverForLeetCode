class Solution {
    public boolean possiblyEquals(String s1, String s2) {
        
        int n1 = s1.length();
        int n2 = s2.length();
        if (n1 == 0 && n2 == 0) {
            return true;
        }
        if (n1 == 0 || n2 == 0) {
            return false;
        }
        if (s1.charAt(0) == '0' || s2.charAt(0) == '0') {
            return false;
        }
        if (n1 > 1 && s1.charAt(0) == '1') {
            if (possiblyEquals(s1.substring(1), s2.substring(1))) {
                return true;
            }
        }
        if (n1 > 2 && s1.charAt(0) == '2' && s1.charAt(1) <= '5') {
            if (possiblyEquals(s1.substring(2), s2.substring(2))) {
                return true;
            }
        }
        if (n2 > 1 && s2.charAt(0) == '1') {
            if (possiblyEquals(s1.substring(1), s2.substring(1))) {
                return true;
            }
        }
        if (n2 > 2 && s2.charAt(0) == '2' && s2.charAt(1) <= '5') {
            if (possiblyEquals(s1.substring(2), s2.substring(2))) {
                return true;
            }
        }
        return false;
    }

    public boolean isPossible(String s1, String s2, int i1, int i2, int n1, int n2) {
        if (i1 == n1 && i2 == n2) {
            return true;
        }
        if (i1 == n1) {
            return s2.charAt(i2) == '0';
        }
        if (i2 == n2) {
            return s1.charAt(i1) == '0';
        }
        if (s1.charAt(i1) == '0' || s2.charAt(i2) == '0') {
            return false;
        }
        if (s1.charAt(i1) == '1') {
            if (isPossible(s1, s2, i1 + 1, i2 + 1, n1, n2)) {
                return true;
            }
        }
        if (s1.charAt(i1) == '
    }
}