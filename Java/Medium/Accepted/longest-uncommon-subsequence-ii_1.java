class Solution {
    public int findLUSlength(String[] strs) {
        
        int result = -1;
        for (int i = 0; i < strs.length; i++) {
            int j = 0;
            for (; j < strs.length; j++) {
                if (i != j && isSubsequence(strs[i], strs[j])) {
                    break;
                }
            }
            if (j == strs.length) {
                result = Math.max(result, strs[i].length());
            }
        }
        return result;
    }
    
    private boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }
}