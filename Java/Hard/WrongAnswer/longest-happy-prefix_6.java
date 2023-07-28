class Solution {
    public String longestPrefix(String s) {
        
        int n = s.length();
        int[] next = new int[n];
        next[0] = -1;
        int i = 0;
        int j = -1;
        while (i < n - 1) {
            if (j == -1 || s.charAt(i) == s.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return s.substring(0, next[n - 1] + 1);
    }
}