class Solution {
public:
    int stoneGameVIII(vector<int>& stones) {
        
        int n = stones.size();
        vector<int> sums(n);
        sums[0] = stones[0];
        for (int i = 1; i < n; ++i) {
            sums[i] = sums[i - 1] + stones[i];
        }
        int dp = sums[n - 1];
        for (int i = n - 2; i > 0; --i) {
            dp = max(dp, sums[i] - dp);
        }
        return dp;
    }
};