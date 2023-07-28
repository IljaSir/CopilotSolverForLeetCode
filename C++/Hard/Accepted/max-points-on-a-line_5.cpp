class Solution {
public:
    int maxPoints(vector<vector<int>>& points) {
        
        int n = points.size();
        if (n < 3) return n;
        int result = 0;
        for (int i = 0; i < n; i++) {
            int duplicate = 1;
            unordered_map<double, int> count;
            for (int j = i + 1; j < n; j++) {
                if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                    duplicate++;
                    continue;
                }
                double slope = points[i][0] == points[j][0] ? INT_MAX : 1.0 * (points[j][1] - points[i][1]) / (points[j][0] - points[i][0]);
                count[slope]++;
            }
            result = max(result, duplicate);
            for (auto it = count.begin(); it != count.end(); it++) {
                result = max(result, it->second + duplicate);
            }
        }
        return result;
    }
};