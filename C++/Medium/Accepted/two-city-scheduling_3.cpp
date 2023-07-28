class Solution {
public:
    int twoCitySchedCost(vector<vector<int>>& costs) {
        
        int n = costs.size();
        vector<pair<int, int>> diff(n);
        for (int i = 0; i < n; i++) {
            diff[i] = {costs[i][0] - costs[i][1], i};
        }
        sort(diff.begin(), diff.end());
        int res = 0;
        for (int i = 0; i < n / 2; i++) {
            res += costs[diff[i].second][0];
        }
        for (int i = n / 2; i < n; i++) {
            res += costs[diff[i].second][1];
        }
        return res;
    }
};