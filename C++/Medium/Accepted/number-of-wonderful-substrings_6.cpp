class Solution {
public:
    long long wonderfulSubstrings(string word) {
        
        int n = word.size();
        vector<int> f(1 << 10);
        f[0] = 1;
        int mask = 0;
        long long ans = 0;
        for (int i = 0; i < n; ++i) {
            mask ^= (1 << (word[i] - 'a'));
            ans += f[mask];
            for (int j = 0; j < 10; ++j) {
                ans += f[mask ^ (1 << j)];
            }
            ++f[mask];
        }
        return ans;
    }
};