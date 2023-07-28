class Solution {
    public String longestPrefix(String s) {
        
        int n = s.length();
        if (n == 1) return "";
        int[] next = new int[n];
        next[0] = -1;
        next[1] = 0;
        int i = 1, j = 0;
        while (i < n-1) {
            if (j == -1 || s.charAt(i) == s.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return s.substring(0, next[n-1]);
    }
}