class Solution {
public:
    bool primeSubOperation(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> prime(1001, 1);
        prime[0] = prime[1] = 0;
        for (int i = 2; i * i <= 1000; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= 1000; j += i) {
                    prime[j] = 0;
                }
            }
        }
        vector<int> p;
        for (int i = 0; i <= 1000; i++) {
            if (prime[i]) {
                p.push_back(i);
            }
        }
        int m = p.size();
        vector<vector<int>> dp(n, vector<int>(m, 0));
        for (int i = 0; i < m; i++) {
            if (nums[0] > p[i]) {
                dp[0][i] = nums[0] - p[i];
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (nums[i] > p[j]) {
                    for (int k = 0; k < m; k++) {
                        if (dp[i - 1][k] && dp[i - 1][k] < p[j]) {
                            dp[i][j] = nums[i] - p[j];
                            break;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            if (dp[n - 1][i]) {
                return true;
            }
        }
        return false;
    }
};