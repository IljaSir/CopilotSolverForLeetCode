class Solution {
    public int findLUSlength(String[] strs) {
        
        int longest = -1;
        for (int i = 0; i < strs.length; i++) {
            int j = 0;
            for (; j < strs.length; j++) {
                if (i == j) continue;
                if (isSubsequence(strs[i], strs[j])) break;
            }
            if (j == strs.length) longest = Math.max(longest, strs[i].length());
        }
        return longest;
    }

    private boolean isSubsequence(String s, String t) {
        int i = 0;
        for (char c : t.toCharArray()) {
            if (i < s.length() && c == s.charAt(i)) i++;
        }
        return i == s.length();
    }
}