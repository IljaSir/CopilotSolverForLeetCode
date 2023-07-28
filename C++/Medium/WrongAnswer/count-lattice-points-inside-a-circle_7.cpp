class Solution {
public:
    int countLatticePoints(vector<vector<int>>& circles) {
        
        int ans = 0;
        for (int i = 0; i < circles.size(); i++) {
            for (int j = i + 1; j < circles.size(); j++) {
                long long dx = circles[i][0] - circles[j][0];
                long long dy = circles[i][1] - circles[j][1];
                long long d2 = dx * dx + dy * dy;
                if (d2 <= 4 * circles[i][2] * circles[j][2]) {
                    ans += 2;
                }
            }
            ans += 4 * circles[i][2];
        }
        return ans;
    }
};