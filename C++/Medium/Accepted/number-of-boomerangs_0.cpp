class Solution {
public:
    int numberOfBoomerangs(vector<vector<int>>& points) {
        
        int res = 0;
        for (int i = 0; i < points.size(); i++) {
            unordered_map<int, int> m;
            for (int j = 0; j < points.size(); j++) {
                if (j == i) continue;
                int dis = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                m[dis]++;
            }
            for (auto it = m.begin(); it != m.end(); it++) {
                res += it->second * (it->second - 1);
            }
        }
        return res;
    }
};