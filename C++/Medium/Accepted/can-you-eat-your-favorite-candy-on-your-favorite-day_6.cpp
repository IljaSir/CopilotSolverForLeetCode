class Solution {
public:
    vector<bool> canEat(vector<int>& candiesCount, vector<vector<int>>& queries) {
        
        int n = candiesCount.size();
        vector<long long> preSum(n + 1, 0);
        for (int i = 1; i <= n; ++i) {
            preSum[i] = preSum[i - 1] + candiesCount[i - 1];
        }
        vector<bool> ans;
        for (auto &q : queries) {
            int type = q[0], day = q[1], cap = q[2];
            long long minCandies = day + 1;
            long long maxCandies = (long long)(day + 1) * cap;
            long long minCandiesType = preSum[type] + 1;
            long long maxCandiesType = preSum[type + 1];
            ans.push_back(minCandies <= maxCandiesType && maxCandies >= minCandiesType);
        }
        return ans;
    }
};