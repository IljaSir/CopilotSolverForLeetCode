class Solution {
public:
    vector<bool> canEat(vector<int>& candiesCount, vector<vector<int>>& queries) {
        
        int n = candiesCount.size();
        vector<long long> sum(n + 1, 0);
        for (int i = 0; i < n; ++i) {
            sum[i + 1] = sum[i] + candiesCount[i];
        }
        vector<bool> ans;
        for (auto& q : queries) {
            int type = q[0], day = q[1], cap = q[2];
            ans.push_back(sum[type] < (long long)(day + 1) * cap && sum[type + 1] > day);
        }
        return ans;
    }
};