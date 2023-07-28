class Solution {
    public boolean possiblyEquals(String s1, String s2) {
        
        if (s1.length() == 0 || s2.length() == 0) {
            return s1.equals(s2);
        }
        if (s1.charAt(0) == '0' || s2.charAt(0) == '0') {
            return false;
        }
        if (s1.charAt(0) == s2.charAt(0)) {
            return possiblyEquals(s1.substring(1), s2.substring(1));
        } else {
            for (int i = 1; i <= 3; i++) {
                if (s1.length() < i) {
                    break;
                }
                String num = s1.substring(0, i);
                if (Integer.parseInt(num) > s2.length()) {
                    break;
                }
                if (s2.startsWith(s1.substring(0, i))) {
                    if (possiblyEquals(s1.substring(i), s2.substring(i))) {
                        return true;
                    }
                }
            }
            for (int i = 1; i <= 3; i++) {
                if (s2.length() < i) {
                    break;
                }
                String num = s2.substring(0, i);
                if (Integer.parseInt(num) > s1.length()) {
                    break;
                }
                if (s1.startsWith(s2.substring(0, i))) {
                    if (possiblyEquals(s1.substring(i), s2.substring(i))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}