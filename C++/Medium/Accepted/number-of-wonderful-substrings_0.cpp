class Solution {
public:
    long long wonderfulSubstrings(string word) {
        
        int n = word.size();
        vector<int> cnt(1 << 10, 0);
        cnt[0] = 1;
        int mask = 0;
        long long ans = 0;
        for (int i = 0; i < n; i++) {
            int c = word[i] - 'a';
            mask ^= (1 << c);
            ans += cnt[mask];
            for (int j = 0; j < 10; j++) {
                int mask2 = mask ^ (1 << j);
                ans += cnt[mask2];
            }
            cnt[mask]++;
        }
        return ans;
    }
};