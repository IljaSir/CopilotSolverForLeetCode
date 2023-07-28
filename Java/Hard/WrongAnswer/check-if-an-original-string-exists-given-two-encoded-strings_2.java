class Solution {
    public boolean possiblyEquals(String s1, String s2) {
        
        int i = 0, j = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else if (s1.charAt(i) >= '1' && s1.charAt(i) <= '9') {
                while (i < s1.length() && s1.charAt(i) >= '1' && s1.charAt(i) <= '9') {
                    i++;
                }
            } else if (s2.charAt(j) >= '1' && s2.charAt(j) <= '9') {
                while (j < s2.length() && s2.charAt(j) >= '1' && s2.charAt(j) <= '9') {
                    j++;
                }
            } else {
                return false;
            }
        }
        return i == s1.length() && j == s2.length();
    }
}