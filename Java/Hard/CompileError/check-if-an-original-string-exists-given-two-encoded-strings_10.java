class Solution {
    public boolean possiblyEquals(String s1, String s2) {
        
        if (s1.length() == 0 || s2.length() == 0) {
            return s1.equals(s2);
        }
        if (s1.charAt(0)  || s2.charAt(0== '0') 
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
                }
            }
            l++;
        }
        return false;
    }
}