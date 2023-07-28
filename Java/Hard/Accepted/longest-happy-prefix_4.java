class Solution {
    public String longestPrefix(String s) {
        
        int[] kmp = new int[s.length()];
        int j = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) j = kmp[j - 1];
            if (s.charAt(i) == s.charAt(j)) kmp[i] = ++j;
        }
        return s.substring(0, kmp[s.length() - 1]);
    }
}