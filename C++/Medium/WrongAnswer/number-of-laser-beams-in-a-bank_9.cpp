class Solution {
public:
    int numberOfBeams(vector<string>& bank) {
        
        int m = bank.size();
        int n = bank[0].size();
        vector<int> dp(n, 0);
        for (int i = 0; i < m; i++) {
            int pre = 0;
            for (int j = 0; j < n; j++) {
                if (bank[i][j] == '1') {
                    pre++;
                    dp[j] += pre;
                }
            }
        }
        int res = 0;
        for (auto& x : dp) {
            res += x;
        }
        return res;
    }
};