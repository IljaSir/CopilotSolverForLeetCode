class Solution {
public:
    int numberOfBoomerangs(vector<vector<int>>& points) {
        
        int n = points.size();
        int ret = 0;
        for (int i = 0; i < n; i++) {
            unordered_map<int, int> dist;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int dx = points[i][0] - points[j][0];
                int dy = points[i][1] - points[j][1];
                int d = dx * dx + dy * dy;
                dist[d]++;
            }
            for (auto it : dist) {
                ret += it.second * (it.second - 1);
            }
        }
        return ret;
    }
};