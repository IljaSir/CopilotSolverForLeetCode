class Solution {
public:
    int minimumRecolors(string blocks, int k) {
        
        int n = blocks.size();
        vector<int> dp(n + 1, 0);
        int j = 0;
        int ans = INT_MAX;
        for(int i = 0; i < n; ++i) {
            if(blocks[i] == 'B') {
                dp[i + 1] = dp[i] + 1;
            } else {
                dp[i + 1] = dp[i];
            }
            if(i - j + 1 == k) {
                ans = min(ans, dp[i + 1] - dp[j]);
                j++;
            }
        }
        return ans;
    }
};