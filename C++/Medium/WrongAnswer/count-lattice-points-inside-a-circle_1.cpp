class Solution {
public:
    int countLatticePoints(vector<vector<int>>& circles) {
        
        int ans = 0;
        for (int i = 0; i < circles.size(); ++i) {
            int x = circles[i][0], y = circles[i][1], r = circles[i][2];
            for (int j = 0; j < circles.size(); ++j) {
                if (i == j) continue;
                int x1 = circles[j][0], y1 = circles[j][1], r1 = circles[j][2];
                int dx = x1 - x, dy = y1 - y, dr = r1 - r;
                if (dx * dx + dy * dy <= dr * dr) {
                    ans += 4 * r + 1;
                    break;
                }
            }
        }
        return ans;
    }
};