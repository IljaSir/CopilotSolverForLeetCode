class Solution {
    public int findLUSlength(String[] strs) {
        
        int max = -1;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() > max) {
                int j = 0;
                for (; j < strs.length; j++) {
                    if (i != j && isSubsequence(strs[i], strs[j])) {
                        break;
                    }
                }
                if (j == strs.length) {
                    max = strs[i].length();
                }
            }
        }
        return max;
    }
    private boolean isSubsequence(String s, String t) {
        int i = 0;
        for (int j = 0; j < t.length() && i < s.length(); j++) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
        }
        return i == s.length();
    }
}