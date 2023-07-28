class Solution {
public:
    int nearestValidPoint(int x, int y, vector<vector<int>>& points) {
        
        int minDist = INT_MAX, minIdx = -1;
        for (int i = 0; i < points.size(); ++i) {
            if (points[i][0] == x || points[i][1] == y) {
                int dist = abs(points[i][0] - x) + abs(points[i][1] - y);
                if (dist < minDist) {
                    minDist = dist;
                    minIdx = i;
                }
            }
        }
        return minIdx;
    }
};