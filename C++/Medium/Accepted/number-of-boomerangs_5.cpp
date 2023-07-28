class Solution {
public:
    int numberOfBoomerangs(vector<vector<int>>& points) {
        
        int n = points.size();
        int res = 0;
        for (int i = 0; i < n; i++) {
            unordered_map<int, int> mp;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int dis = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                mp[dis]++;
            }
            for (auto& [k, v] : mp) {
                res += v * (v - 1);
            }
        }
        return res;
    }
};