class Solution {
    public boolean possiblyEquals(String s1, String s2) {
        
        int n = s1.length();
        int m = s2.length();
        if (n == 0 || m == 0) {
            return false;
        }
        if (n == 1 && m == 1) {
            return s1.charAt(0) == s2.charAt(0);
        }
        if (s1.charAt(0) == s2.charAt(0)) {
            return possiblyEquals(s1.substring(1), s2.substring(1));
        }
        if (n > m) {
            return possiblyEquals(s2, s1);
        }
        if (s1.charAt(0) == '0') {
            return false;
        }
        int l = 1;
        while (l <= 3 && l <= n - 1) {
            int num = Integer.parseInt(s1.substring(0, l));
            if (s2.startsWith(String.valueOf(num))) {
                if (possiblyEqualss1.substrng(lStrng.valueOf(num.length())
                    return true;
                }
            }
            l++;
        }
        return false;
    }
}