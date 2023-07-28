class Solution {
public:
    bool checkStraightLine(vector<vector<int>>& coordinates) {
        
        int n = coordinates.size();
        if (n == 2) return true;
        int dx = coordinates[1][0] - coordinates[0][0];
        int dy = coordinates[1][1] - coordinates[0][1];
        for (int i = 2; i < n; ++i) {
            int dx2 = coordinates[i][0] - coordinates[0][0];
            int dy2 = coordinates[i][1] - coordinates[0][1];
            if (dx * dy2 != dx2 * dy) return false;
        }
        return true;
    }
};