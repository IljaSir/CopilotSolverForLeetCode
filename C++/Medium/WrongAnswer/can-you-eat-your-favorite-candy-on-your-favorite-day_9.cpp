class Solution {
public:
    vector<bool> canEat(vector<int>& candiesCount, vector<vector<int>>& queries) {
        
        int n = candiesCount.size();
        vector<bool> ans(queries.size(), true);
        vector<long> sum(n, 0);
        sum[0] = candiesCount[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + candiesCount[i];
        }
        for (int i = 0; i < queries.size(); i++) {
            int type = queries[i][0];
            int day = queries[i][1];
            int cap = queries[i][2];
            long min = (type == 0 ? 0 : sum[type - 1]) + 1;
            long max = sum[type];
            if (day + 1 < min || day + 1 > max) {
                ans[i] = false;
            }
            if (day + 1 > max / cap) {
                ans[i] = false;
            }
        }
        return ans;
    }
};