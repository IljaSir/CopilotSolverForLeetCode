class Solution {
    public int findSubstringInWraproundString(String s) {
        
        int[] count = new int[26];
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && (s.charAt(i) - s.charAt(i - 1) == 1 || s.charAt(i) - s.charAt(i - 1) == -25)) {
                maxLen++;
            } else {
                maxLen = 1;
            }
            int index = s.charAt(i) - 'a';
            count[index] = Math.max(count[index], maxLen);
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            res += count[i];
        }
        return res;
    }
}