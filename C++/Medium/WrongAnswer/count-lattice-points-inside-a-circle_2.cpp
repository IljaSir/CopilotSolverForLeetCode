class Solution {
public:
    int countLatticePoints(vector<vector<int>>& circles) {
        
        int n = circles.size();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int x = circles[i][0], y = circles[i][1], r = circles[i][2];
            ans += 4 * r + 1;
            for (int j = 0; j < i; j++) {
                int x1 = circles[j][0], y1 = circles[j][1], r1 = circles[j][2];
                int dis = (x - x1) * (x - x1) + (y - y1) * (y - y1);
                if (dis >= (r + r1) * (r + r1)) continue;
                if (dis <= (r - r1) * (r - r1)) {
                    ans -= 4 * r1 + 1;
                    continue;
                }
                int d = sqrt(dis);
                int x2 = x1 + (x - x1) * r1 / d;
                int y2 = y1 + (y - y1) * r1 / d;
                int x3 = x + (x1 - x) * r / d;
                int y3 = y + (y1 - y) * r / d;
                int x4 = x2 + (x3 - x2) * (r - r1) / (r + r1);
                int y4 = y2 + (y3 - y2) * (r - r1) / (r + r1);
                ans -= (r1 * r1 + r1 * (r - r1) - (x2 - x4) * (x2 - x4) - (y2 - y4) * (y2 - y4)) / 2;
                ans -= (r * r + r * (r1 - r) - (x3 - x4) * (x3 - x4) - (y3 - y4) * (y3 - y4)) / 2;
            }
        }
        return ans;
    }
};