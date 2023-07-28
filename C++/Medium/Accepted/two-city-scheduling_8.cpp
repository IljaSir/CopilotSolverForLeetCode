class Solution {
public:
    int twoCitySchedCost(vector<vector<int>>& costs) {
        
        int n = costs.size()/2;
        int res = 0;
        vector<int> diff(n*2, 0);
        for(int i = 0; i < costs.size(); i++) {
            diff[i] = costs[i][0] - costs[i][1];
            res += costs[i][1];
        }
        sort(diff.begin(), diff.end());
        for(int i = 0; i < n; i++) {
            res += diff[i];
        }
        return res;
    }
};