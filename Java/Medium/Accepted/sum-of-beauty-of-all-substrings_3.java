class Solution {
    public int beautySum(String s) {
        
        int ans = 0;
        for (int i = 0; i < s.length(); ++i) {
            int[] cnt = new int[26];
            for (int j = i; j < s.length(); ++j) {
                cnt[s.charAt(j) - 'a']++;
                int max = 0;
                int min = 500;
                for (int k = 0; k < 26; ++k) {
                    if (cnt[k] > 0) {
                        max = Math.max(max, cnt[k]);
                        min = Math.min(min, cnt[k]);
                    }
                }
                ans += max - min;
            }
        }
        return ans;
    }
}