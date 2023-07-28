class Solution {
public:
    bool checkStraightLine(vector<vector<int>>& coordinates) {
        
        if (coordinates.size() == 2) return true;
        double x0 = coordinates[0][0], y0 = coordinates[0][1];
        double x1 = coordinates[1][0], y1 = coordinates[1][1];
        double k = (y1 - y0) / (x1 - x0);
        for (int i = 2; i < coordinates.size(); i++) {
            double x = coordinates[i][0], y = coordinates[i][1];
            if (abs((y - y0) / (x - x0) - k) > 1e-8) return false;
        }
        return true;
    }
};