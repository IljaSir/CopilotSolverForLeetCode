class Solution {
public:
    double minAreaFreeRect(vector<vector<int>>& points) {
        
        int n = points.size();
        if (n < 4) return 0;
        double ans = INT_MAX;
        vector<vector<int>> squares;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int m = k + 1; m < n; m++) {
                        int a = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                        int b = (points[i][0] - points[k][0]) * (points[i][0] - points[k][0]) + (points[i][1] - points[k][1]) * (points[i][1] - points[k][1]);
                        int c = (points[i][0] - points[m][0]) * (points[i][0] - points[m][0]) + (points[i][1] - points[m][1]) * (points[i][1] - points[m][1]);
                        if (a == b && a + b == c) {
                            int d = (points[j][0] - points[k][0]) * (points[j][0] - points[k][0]) + (points[j][1] - points[k][1]) * (points[j][1] - points[k][1]);
                            int e = (points[j][0] - points[m][0]) * (points[j][0] - points[m][0]) + (points[j][1] - points[m][1]) * (points[j][1] - points[m][1]);
                            int f = (points[k][0] - points[m][0]) * (points[k][0] - points[m][0]) + (points[k][1] - points[m][1]) * (points[k][1] - points[m][1]);
                            if (d == e && d + e == f) {
                                ans = min(ans, sqrt(a) * sqrt(d));
                            }
                        }
                    }
                }
            }
        }
        if (ans == INT_MAX) return 0;
    }
};