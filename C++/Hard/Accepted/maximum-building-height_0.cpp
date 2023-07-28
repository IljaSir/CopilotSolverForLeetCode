class Solution {
public:
    int maxBuilding(int n, vector<vector<int>>& restrictions) {
        
        sort(restrictions.begin(), restrictions.end());
        if(restrictions.empty() || restrictions[0][0] != 1)
            restrictions.insert(restrictions.begin(), {1, 0});
        if(restrictions.back()[0] != n)
            restrictions.push_back({n, n-1});
        for(int i = 1; i < restrictions.size(); ++i) {
            restrictions[i][1] = min(restrictions[i][1], restrictions[i - 1][1] + restrictions[i][0] - restrictions[i - 1][0]);
        }
        for(int i = restrictions.size() - 2; i >= 0; --i) {
            restrictions[i][1] = min(restrictions[i][1], restrictions[i + 1][1] + restrictions[i + 1][0] - restrictions[i][0]);
        }
        int ans = 0;
        for(int i = 1; i < restrictions.size(); ++i) {
            int d = restrictions[i][0] - restrictions[i - 1][0];
            int h = abs(restrictions[i][1] - restrictions[i - 1][1]);
            ans = max(ans, max(restrictions[i][1], restrictions[i - 1][1]) + (d - h) / 2);
        }
        return ans;
    }
};