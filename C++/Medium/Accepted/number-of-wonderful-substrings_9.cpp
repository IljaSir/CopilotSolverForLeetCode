class Solution {
public:
    long long wonderfulSubstrings(string word) {
        
        long long ans = 0;
        vector<int> dp(1024,0);
        dp[0] = 1;
        int mask = 0;
        for (int i = 0; i < word.size(); i++) {
            mask ^= (1 << (word[i] - 'a'));
            ans += dp[mask];
            for (int j = 0; j < 10; j++) {
                ans += dp[mask ^ (1 << j)];
            }
            dp[mask]++;
        }
        return ans;
    }
};