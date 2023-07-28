class Solution {
public:
    int minSideJumps(vector<int>& obstacles) {
        
        int n = obstacles.size();
        int f[n][3];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 3; j++) {
                f[i][j] = 0x3f3f3f3f;
            }
        }
        f[0][1] = 0;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < 3; j++) {
                if(obstacles[i] == j + 1) {
                    f[i][j] = 0x3f3f3f3f;
                } else {
                    f[i][j] = f[i - 1][j];
                }
            }
            for(int j = 0; j < 3; j++) {
                if(obstacles[i] == j + 1) {
                    continue;
                }
                for(int k = 0; k < 3; k++) {
                    if(k == j || obstacles[i] == k + 1) {
                        continue;
                    }
                    f[i][j] = min(f[i][j], f[i][k] + 1);
                }
            }
        }
        return min({f[n - 1][0], f[n - 1][1], f[n - 1][2]});
    }
};