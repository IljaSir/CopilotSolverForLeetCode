class Solution {
public:
    int twoCitySchedCost(vector<vector<int>>& costs) {
        
        sort(costs.begin(), costs.end(), [](vector<int> &a, vector<int> &b) { return a[0] - a[1] < b[0] - b[1]; });
        int total = 0;
        for (int i = 0; i < costs.size(); ++i) {
            if (i < costs.size() / 2) {
                total += costs[i][0];
            } else {
                total += costs[i][1];
            }
        }
        return total;
    }
};