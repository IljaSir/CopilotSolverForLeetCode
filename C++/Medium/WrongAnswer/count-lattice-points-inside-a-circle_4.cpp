class Solution {
public:
    int countLatticePoints(vector<vector<int>>& circles) {
        
        int res = 0;
        int n = circles.size();
        for (int i = 0; i < n; i++) {
            int x1 = circles[i][0];
            int y1 = circles[i][1];
            int r1 = circles[i][2];
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int x2 = circles[j][0];
                int y2 = circles[j][1];
                int r2 = circles[j][2];
                int dx = x1 - x2;
                int dy = y1 - y2;
                int d2 = dx * dx + dy * dy;
                int r12 = r1 * r1;
                int r22 = r2 * r2;
                if (d2 <= r12 && d2 <= r22) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }
};