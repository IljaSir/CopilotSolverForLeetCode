class Solution {
public:
    bool checkStraightLine(vector<vector<int>>& coordinates) {
        
        for (int i = 2; i < coordinates.size(); i++) {
            if ((coordinates[i][0] - coordinates[i - 1][0]) * (coordinates[i - 1][1] - coordinates[i - 2][1]) !=
                (coordinates[i][1] - coordinates[i - 1][1]) * (coordinates[i - 1][0] - coordinates[i - 2][0])) {
                return false;
            }
        }
        return true;
    }
};