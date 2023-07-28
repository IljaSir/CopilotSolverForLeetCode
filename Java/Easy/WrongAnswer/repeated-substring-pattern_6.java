class Solution {
    public boolean repeatedSubstringPattern(String s) {
        
        if (s == null || s.length() == 0) return false;
        int[] next = new int[s.length()];
        next[0] = -1;
        int i = 0;
        int j = -1;
        while (i < s.length() - 1) {
            if (j == -1 || s.charAt(i) == s.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next[s.length() - 1] != -1 && s.length() % (s.length() - next[s.length() - 1] - 1) == 0;
    }
}