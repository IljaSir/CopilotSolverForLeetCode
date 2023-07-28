class Solution {
public:
    int twoCitySchedCost(vector<vector<int>>& costs) {
        
        int n = costs.size() / 2;
        int res = 0;
        vector<int> diff;
        for (auto c : costs) {
            res += c[0];
            diff.push_back(c[1] - c[0]);
        }
        sort(diff.begin(), diff.end());
        for (int i = 0; i < n; i++) {
            res += diff[i];
        }
        return res;
    }
};