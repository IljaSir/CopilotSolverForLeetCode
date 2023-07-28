class Solution {
public:
    vector<bool> canEat(vector<int>& candiesCount, vector<vector<int>>& queries) {
        
        int n = candiesCount.size();
        vector<long long> sum(n, 0);
        sum[0] = candiesCount[0];
        for (int i = 1; i < n; ++i)
            sum[i] = sum[i - 1] + candiesCount[i];
        vector<bool> ans;
        for (auto& q : queries) {
            int type = q[0], day = q[1], cap = q[2];
            long long x1 = day + 1, y1 = (long long)(day + 1) * cap;
            long long x2 = (type == 0 ? 1 : sum[type - 1] + 1), y2 = sum[type];
            ans.push_back(!(x1 > y2 || y1 < x2));
        }
        return ans;
    }
};