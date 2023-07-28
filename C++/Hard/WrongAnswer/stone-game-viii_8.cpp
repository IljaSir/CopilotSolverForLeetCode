class Solution {
public:
    int stoneGameVIII(vector<int>& stones) {
        
        int n = stones.size();
        vector<int> s(n+1, 0);
        for (int i = 0; i < n; ++i) {
            s[i+1] = s[i] + stones[i];
        }
        int dp = s[n];
        int res = dp;
        for (int i = n-1; i > 1; --i) {
            dp = max(dp, s[i]);
            res = max(res, dp - s[i-1]);
        }
        return res;
    }
};