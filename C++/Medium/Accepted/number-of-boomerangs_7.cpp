class Solution {
public:
    int numberOfBoomerangs(vector<vector<int>>& points) {
        
        int n = points.size();
        int res = 0;
        for (int i = 0; i < n; ++i) {
            unordered_map<int, int> map;
            for (int j = 0; j < n; ++j) {
                if (i == j) continue;
                int dist = pow(points[i][0] - points[j][0], 2) + pow(points[i][1] - points[j][1], 2);
                map[dist]++;
            }
            for (auto it = map.begin(); it != map.end(); ++it) {
                res += it->second * (it->second - 1);
            }
        }
        return res;
    }
};