class Solution {
    public int findSubstringInWraproundString(String s) {
        
        int[] maxLen = new int[26];
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && (s.charAt(i) - s.charAt(i - 1) == 1 || s.charAt(i - 1) - s.charAt(i) == 25)) {
                len++;
            } else {
                len = 1;
            }
            int index = s.charAt(i) - 'a';
            maxLen[index] = Math.max(maxLen[index], len);
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            res += maxLen[i];
        }
        return res;
    }
}