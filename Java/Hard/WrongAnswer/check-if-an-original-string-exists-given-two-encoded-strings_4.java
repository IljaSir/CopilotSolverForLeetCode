class Solution {
    public boolean possiblyEquals(String s1, String s2) {
        
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.length() == 0) {
            return true;
        }
        if (s1.charAt(0) == '0') {
            return false;
        }
        if (s1.length() == 1) {
            return true;
        }
        int n = s1.length();
        for (int i = 1; i < n; i++) {
            String s1Left = s1.substring(0, i);
            String s1Right = s1.substring(i);
            String s2Left = s2.substring(0, i);
            String s2Right = s2.substring(i);
            if (possiblyEquals(s1Left, s2Left) && possiblyEquals(s1Right, s2Right)) {
                return true;
            }
            if (s2.charAt(0) != '0' && s1Left.length() > 1 && s1Left.charAt(0) != '0' && s2Left.length() > 1 && s2Left.charAt(0) != '0') {
                int s1LeftNum = Integer.parseInt(s1Left);
                int s2LeftNum = Integer.parseInt(s2Left);
                if (s1LeftNum + 1 == s2LeftNum || s2LeftNum + 1 == s1LeftNum) {
                    if (possiblyEquals(s1Left, s2Right) && possiblyEquals(s1Right, s2Left)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}