class Solution {
    public int characterReplacement(String s, int k) {
        
        int[] cnt = new int[26];
        int i = 0;
        int j = 0;
        int maxCnt = 0;
        while (j < s.length()) {
            maxCnt = Math.max(maxCnt, ++cnt[s.charAt(j) - 'A']);
            if (j - i + 1 - maxCnt > k) {
                cnt[s.charAt(i) - 'A']--;
                i++;
            }
            j++;
        }
        return j - i;
    }
}