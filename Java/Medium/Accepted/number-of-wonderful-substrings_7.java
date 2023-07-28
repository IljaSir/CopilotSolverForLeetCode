class Solution {
    public long wonderfulSubstrings(String word) {
        
        int[] cnt = new int[1024];
        cnt[0] = 1;
        int status = 0;
        long ans = 0;
        for (int i = 0; i < word.length(); i++) {
            status ^= 1 << (word.charAt(i) - 'a');
            ans += cnt[status];
            for (int j = 0; j < 10; j++) {
                ans += cnt[status ^ (1 << j)];
            }
            cnt[status]++;
        }
        return ans;
    }
}