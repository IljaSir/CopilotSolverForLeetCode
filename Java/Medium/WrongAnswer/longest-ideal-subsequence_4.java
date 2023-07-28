class Solution {
    public int longestIdealString(String s, int k) {
        
        int n = s.length();
        int[] cnt = new int[26];
        int l = 0;
        int r = 0;
        int res = 0;
        while (r < n) {
            cnt[s.charAt(r) - 'a']++;
            while (l < r && cnt[s.charAt(r) - 'a'] - cnt[s.charAt(l) - 'a'] > k) {
                cnt[s.charAt(l) - 'a']--;
                l++;
            }
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }
}