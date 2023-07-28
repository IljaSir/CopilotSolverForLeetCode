class Solution {
public:
    int nearestValidPoint(int x, int y, vector<vector<int>>& points) {
        
        int minDist = INT_MAX;
        int minIdx = -1;
        for (int i = 0; i < points.size(); ++i) {
            if (points[i][0] == x || points[i][1] == y) {
                int dist = abs(x - points[i][0]) + abs(y - points[i][1]);
                if (dist < minDist) {
                    minDist = dist;
                    minIdx = i;
                }
            }
        }
        return minIdx;
    }
};