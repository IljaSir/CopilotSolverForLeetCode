class Solution {
public:
    bool canDistribute(vector<int>& nums, vector<int>& quantity) {
        
        unordered_map<int, int> count;
        for (int num : nums) {
            count[num]++;
        }
        vector<int> freq;
        for (auto& [num, c] : count) {
            freq.push_back(c);
        }
        sort(freq.begin(), freq.end(), greater<int>());
        sort(quantity.begin(), quantity.end(), greater<int>());
        int n = freq.size(), m = quantity.size();
        vector<vector<bool>> dp(n + 1, vector<bool>(1 << m));
        dp[0][0] = true;
        for (int i = 0; i < n; i++) {
            for (int mask = 0; mask < (1 << m); mask++) {
                if (!dp[i][mask]) {
                    continue;
                }
                dp[i + 1][mask] = true;
                int left = freq[i];
                for (int j = 0; j < m; j++) {
                    if (mask & (1 << j)) {
                        continue;
                    }
                    if (left >= quantity[j]) {
                        left -= quantity[j];
                        dp[i + 1][mask | (1 << j)] = true;
                    }
                }
            }
        }
        return dp[n][(1 << m) - 1];
    }
};