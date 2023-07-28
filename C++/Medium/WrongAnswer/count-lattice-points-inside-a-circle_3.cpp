class Solution {
public:
    int countLatticePoints(vector<vector<int>>& circles) {
        
        int res = 0;
        for (auto c : circles) {
            int x = c[0], y = c[1], r = c[2];
            for (int i = x - r; i <= x + r; i++) {
                for (int j = y - r; j <= y + r; j++) {
                    if (i * i + j * j <= r * r) {
                        res++;
                    }
                }
            }
        }
        return res;
    }
};