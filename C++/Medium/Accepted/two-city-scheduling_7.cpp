class Solution {
public:
    int twoCitySchedCost(vector<vector<int>>& costs) {
        
        int res = 0;
        vector<int> sub;
        for (auto cost : costs) {
            res += cost[0];
            sub.push_back(cost[1] - cost[0]);
        }
        sort(sub.begin(), sub.end());
        for (int i = 0; i < sub.size() / 2; i++) {
            res += sub[i];
        }
        return res;
    }
};