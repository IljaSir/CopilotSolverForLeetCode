class Solution {
    public boolean possiblyEquals(String s1, String s2) {
        
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        if (s1.length() < 3) {
            return false;
        }
        for (int i = 1; i < s1.length() - 1; i++) {
            String s1Left = s1.substring(0, i);
            String s1Right = s1.substring(i);
            String s2Left = s2.substring(0, i);
            String s2Right = s2.substring(i);
            if (possiblyEquals(s1Left, s2Left) && possiblyEquals(s1Right, s2Right)) {
                return true;
            }
            String s2LeftReversed = new StringBuilder(s2Left).reverse().toString();
            String s2RightReversed = new StringBuilder(s2Right).reverse().toString();
            if (possiblyEquals(s1Left, s2LeftReversed) && possiblyEquals(s1Right, s2RightReversed)) {
                return true;
            }
        }
        return false;
    }
    public boolean isDecodable(String s) {
        int n = s.length();
        if (n == 0) {
            return true;
        }
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == '0') {
                return false;
            }
            int j = i + 1;
            while (j < n && s.charAt(j) >= '0' && s.charAt(j) <= '9') {
                j++;
            }
            if (j - i > 3) {
                return false;
            }
            int num = Integer.parseInt(s.substring(i, j));
            if (num > 26) {
                return false;
            }
            i = j;
        }
        return true;
    }
    public boolean isPossible(String s) {
        int n = s.length();
        if (n == 0) {
            return true;
        }
        for (int i = 1; i <= n; i++) {
            String left = s.substring(0, i);
            String right = s.substring(i);
            if (isDecodable(left) && isPossible(right)) {
                return true;
            }
        }
        return false;
    }
}