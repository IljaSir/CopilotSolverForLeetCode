class Solution {
public:
    int numberOfBoomerangs(vector<vector<int>>& points) {
        
        int result = 0;
        for (int i = 0; i < points.size(); i++) {
            unordered_map<int, int> m;
            for (int j = 0; j < points.size(); j++) {
                if (i == j) continue;
                int dist = pow(points[i][0] - points[j][0], 2) + pow(points[i][1] - points[j][1], 2);
                m[dist]++;
            }
            for (auto it = m.begin(); it != m.end(); it++) {
                if (it->second > 1) {
                    result += it->second * (it->second - 1);
                }
            }
        }
        return result;
    }
};