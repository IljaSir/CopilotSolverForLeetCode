class Solution {
public:
    bool checkStraightLine(vector<vector<int>>& coordinates) {
        
        if (coordinates.size() <= 2) {
            return true;
        }
        double k = 0;
        if (coordinates[0][0] == coordinates[1][0]) {
            k = INT_MAX;
        } else {
            k = 1.0 * (coordinates[0][1] - coordinates[1][1]) / (coordinates[0][0] - coordinates[1][0]);
        }
        for (int i = 2; i < coordinates.size(); i++) {
            if (coordinates[i][0] == coordinates[0][0]) {
                if (k != INT_MAX) {
                    return false;
                }
            } else {
                double k1 = 1.0 * (coordinates[i][1] - coordinates[0][1]) / (coordinates[i][0] - coordinates[0][0]);
                if (k1 != k) {
                    return false;
                }
            }
        }
        return true;
    }
};