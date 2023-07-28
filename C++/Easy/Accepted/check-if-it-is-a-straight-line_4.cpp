class Solution {
public:
    bool checkStraightLine(vector<vector<int>>& coordinates) {
        
        int n = coordinates.size();
        if (n == 2) return true;
        int x0 = coordinates[0][0], y0 = coordinates[0][1];
        int x1 = coordinates[1][0], y1 = coordinates[1][1];
        int x2, y2;
        for (int i = 2; i < n; i++) {
            x2 = coordinates[i][0], y2 = coordinates[i][1];
            if ((x2 - x1) * (y1 - y0) != (x1 - x0) * (y2 - y1)) return false;
        }
        return true;
    }
};