class Solution {
public:
    int nearestValidPoint(int x, int y, vector<vector<int>>& points) {
        
        int minDist = INT_MAX, minIdx = -1;
        for (int i = 0; i < points.size(); ++i) {
            int xi = points[i][0], yi = points[i][1];
            if (xi == x || yi == y) {
                int dist = abs(x - xi) + abs(y - yi);
                if (dist < minDist) {
                    minDist = dist;
                    minIdx = i;
                }
            }
        }
        return minIdx;
    }
};