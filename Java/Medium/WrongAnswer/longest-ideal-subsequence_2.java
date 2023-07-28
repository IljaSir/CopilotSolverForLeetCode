class Solution {
    public int longestIdealString(String s, int k) {
        
        int n = s.length();
        int[] cnt = new int[26];
        int res = 0;
        for (int i = 0, j = 0; i < n; i++) {
            cnt[s.charAt(i) - 'a']++;
            while (j < i && cnt[s.charAt(j) - 'a'] > 1) {
                cnt[s.charAt(j) - 'a']--;
                j++;
            }
            if (i - j + 1 >= 26 - k) {
                res = Math.max(res, i - j + 1);
            }
        }
        return res;
    }
}