class Solution {
public:
    int minAreaRect(vector<vector<int>>& points) {
        
        int n = points.size();
        if(n < 4) return 0;
        int ans = INT_MAX;
        unordered_map<int, unordered_set<int>> m;
        for(auto& p: points) {
            m[p[0]].insert(p[1]);
        }
        for(int i = 0; i < n; ++i) {
            for(int j = i+1; j < n; ++j) {
                if(points[i][0] == points[j][0] || points[i][1] == points[j][1]) continue;
                if(m[points[i][0]].count(points[j][1]) && m[points[j][0]].count(points[i][1])) {
                    ans = min(ans, abs(points[i][0] - points[j][0]) * abs(points[i][1] - points[j][1]));
                }
            }
        }
        return ans == INT_MAX ? 0 : ans;
    }
};