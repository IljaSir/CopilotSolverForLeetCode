class Solution {
public:
    int twoCitySchedCost(vector<vector<int>>& costs) {
        
        int n = costs.size() / 2;
        vector<int> diff(n * 2);
        for (int i = 0; i < n * 2; ++i) {
            diff[i] = costs[i][0] - costs[i][1];
        }
        sort(diff.begin(), diff.end());
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += costs[i][0] + costs[i + n][1];
        }
        for (int i = 0; i < n; ++i) {
            ans += diff[i];
        }
        return ans;
    }
};