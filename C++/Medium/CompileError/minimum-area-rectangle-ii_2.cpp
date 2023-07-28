class Solution {
public:
    double minAreaFreeRect(vector<vector<int>>& points) {
        
        int n = points.size();
        double ans = INT_MAX;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                for (int k = j + 1; k < n; ++k) {
                    for (int l = k + 1; l < n; ++l) {
                        if (isRectangle(points[i], points[j], points[k], points[l])) {
                            ans = min(ans, area(points[i], points[j], points[k], points[l]));
                        }
                    }
                }
            }
        }
        return ans == INT_MAX ? 0 : ans;
    }
    
    bool isRectangle(vector<int>& p1, vector<int>& p2, vector<int>& p3, vector<int>& p4) {
        if (p1 == p2 || p1 == p3 || p1 == p4 || p2 == p3 || p2 == p4 || p3 == p4) {
            return false;
        }
        int d12 = (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
        int d13 = (p1[0] - p3[0]) * (p1[0] - p3[0]) + (p1[1] - p3[1]) * (p1[1] - p3[1]);
        int d14 = (p1[0] - p4[0]) * (p1[0] - p4[0]) + (p1[1] - p4[1]) * (p1[1] - p4[1]);
        if (d12 == d13 && d12 + d13 == d14) {
            return true;
        }
        if (d12 == d14 && d12 + d14 == d13) {
            return true;
        }
        if (d13 == d14 && d13 + d14 == d12) {
            return true;
        }
        return false;
    }
};