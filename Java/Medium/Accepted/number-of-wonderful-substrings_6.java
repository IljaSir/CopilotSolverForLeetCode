class Solution {
    public long wonderfulSubstrings(String word) {
        
        long[] cnt = new long[1024];
        cnt[0] = 1;
        long ans = 0;
        int mask = 0;
        for (char c : word.toCharArray()) {
            mask ^= (1 << (c - 'a'));
            ans += cnt[mask];
            for (int i = 0; i < 10; i++) {
                ans += cnt[mask ^ (1 << i)];
            }
            cnt[mask]++;
        }
        return ans;
    }
}