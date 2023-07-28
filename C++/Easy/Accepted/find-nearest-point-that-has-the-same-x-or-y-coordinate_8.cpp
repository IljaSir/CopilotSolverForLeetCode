class Solution {
public:
    int nearestValidPoint(int x, int y, vector<vector<int>>& points) {
        
        int res = -1, minDis = INT_MAX;
        for(int i = 0; i < points.size(); ++i) {
            if(points[i][0] == x || points[i][1] == y) {
                int dis = abs(x - points[i][0]) + abs(y - points[i][1]);
                if(dis < minDis) {
                    minDis = dis;
                    res = i;
                }
            }
        }
        return res;
    }
};