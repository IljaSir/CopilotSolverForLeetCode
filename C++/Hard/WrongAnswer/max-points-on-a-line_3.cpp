class Solution {
public:
    int maxPoints(vector<vector<int>>& points) {
        
        int n = points.size();
        if (n < 3) return n;
        
        int ans = 0;
        for (int i = 0; i < n; i++) {
            map<pair<int, int>, int> lines;
            int dup = 1;
            for (int j = i + 1; j < n; j++) {
                if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                    dup++;
                    continue;
                }
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];
                int d = gcd(dx, dy);
                lines[make_pair(dx / d, dy / d)]++;
            }
            ans = max(ans, dup);
            for (auto it = lines.begin(); it != lines.end(); it++) {
                ans = max(ans, it->second + dup);
            }
        }
        return ans;
    }
};