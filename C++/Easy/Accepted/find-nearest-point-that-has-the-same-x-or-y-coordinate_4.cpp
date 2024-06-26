class Solution {
public:
    int nearestValidPoint(int x, int y, vector<vector<int>>& points) {
        
        int min_dist = INT_MAX, min_index = -1;
        for (int i = 0; i < points.size(); i++) {
            if (points[i][0] == x || points[i][1] == y) {
                int dist = abs(x - points[i][0]) + abs(y - points[i][1]);
                if (dist < min_dist) {
                    min_dist = dist;
                    min_index = i;
                }
            }
        }
        return min_index;
    }
};