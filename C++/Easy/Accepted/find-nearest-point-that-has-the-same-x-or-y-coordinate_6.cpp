class Solution {
public:
    int nearestValidPoint(int x, int y, vector<vector<int>>& points) {
        
        int minD = INT_MAX;
        int minI = -1;
        for (int i = 0; i < points.size(); ++i) {
            if (x == points[i][0] || y == points[i][1]) {
                int d = abs(x - points[i][0]) + abs(y - points[i][1]);
                if (d < minD) {
                    minD = d;
                    minI = i;
                }
            }
        }
        return minI;
    }
};