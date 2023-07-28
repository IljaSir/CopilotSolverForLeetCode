class Solution {
public:
    int numberOfBoomerangs(vector<vector<int>>& points) {
        
        int res = 0;
        int n = points.size();
        for(int i = 0; i < n; i++) {
            unordered_map<int, int> m;
            for(int j = 0; j < n; j++) {
                if(i == j) continue;
                int dx = points[i][0] - points[j][0];
                int dy = points[i][1] - points[j][1];
                m[dx * dx + dy * dy]++;
            }
            for(auto it = m.begin(); it != m.end(); it++) {
                res += it->second * (it->second - 1);
            }
        }
        return res;
    }
};