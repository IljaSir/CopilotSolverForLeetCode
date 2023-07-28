class Solution {
public:
    double minAreaFreeRect(vector<vector<int>>& points) {
        
        int n = points.size();
        double ans = INT_MAX;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        if (isSquare(points[i], points[j], points[k], points[l])) {
                            double area = getArea(points[i], points[j], points[k]);
                            res = min(res, area);
                        }
                    }
                }
            }
        }
        if (res == INT_MAX) return 0;
        return res;
    }
    
    bool isSquare(vector<int>& p1, vector<int>& p2, vector<int>& p3, vector<int>& p4) {
        int d1 = getDist(p1, p2);
        int d2 = getDist(p2, p3);
        int d3 = getDist(p3, p4);
        int d4 = getDist(p4, p1);
        int d5 = getDist(p1, p3);
        int d6 = getDist(p2, p4);
        if (d1 == 0 || d2 == 0 || d3 == 0 || d4 == 0 || d5 == 0 || d6 == 0) return false;
        return (d1 == d2 && d2 == d3 && d3 == d4 && d5 == d6);
    }
    
    double getArea(vector<int>& p1, vector<int>& p2, vector<int>& p3) {
        int d1 = getDist(p1, p2);
        int d2 = getDist(p2, p3);
        return sqrt(d1) * sqrt(d2);
    }
};