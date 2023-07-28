class Solution {
public:
    long long wonderfulSubstrings(string word) {
        
        int n = word.size();
        vector<int> cnt(1<<10, 0);
        cnt[0] = 1;
        int mask = 0;
        long long res = 0;
        for (int i = 0; i < n; ++i) {
            mask ^= (1 << (word[i] - 'a'));
            res += cnt[mask];
            for (int j = 0; j < 10; ++j) {
                res += cnt[mask ^ (1 << j)];
            }
            cnt[mask]++;
        }
        return res;
    }
};