class Solution {
    public long wonderfulSubstrings(String word) {
        
        int n = word.length();
        long ans = 0;
        long[] cnt = new long[1 << 10];
        cnt[0] = 1;
        int status = 0;
        for (int i = 0; i < n; i++) {
            status ^= (1 << (word.charAt(i) - 'a'));
            ans += cnt[status];
            for (int j = 0; j < 10; j++) {
                ans += cnt[status ^ (1 << j)];
            }
            cnt[status]++;
        }
        return ans;
    }
}