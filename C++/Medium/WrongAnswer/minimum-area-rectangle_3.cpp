class Solution {
public:
    int minAreaRect(vector<vector<int>>& points) {
        
        int n = points.size();
        int ans = INT_MAX;
        unordered_map<int, vector<int>> mp;
        for (int i = 0; i < n; i++) {
            mp[points[i][0]].push_back(points[i][1]);
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (points[i][0] == points[j][0] || points[i][1] == points[j][1]) {
                    continue;
                }
                if (binary_search(mp[points[i][0]].begin(), mp[points[i][0]].end(), points[j][1])
                    && binary_search(mp[points[j][0]].begin(), mp[points[j][0]].end(), points[i][1])) {
                    ans = min(ans, abs(points[i][0] - points[j][0]) * abs(points[i][1] - points[j][1]));
                }
            }
        }
        return ans == INT_MAX ? 0 : ans;
    }
};