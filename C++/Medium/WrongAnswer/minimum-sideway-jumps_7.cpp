class Solution {
public:
    int minSideJumps(vector<int>& obstacles) {
        
        int res = 0;
        int n = obstacles.size();
        int pos[3] = {1, 2, 3};
        for (int i = 0; i < n - 1; i++) {
            if (obstacles[i] == 0) {
                continue;
            }
            int lane = obstacles[i] - 1;
            int t = pos[lane];
            pos[lane] = 6 - pos[lane] - pos[(lane + 1) % 3];
            if (pos[lane] == t) {
                res++;
                pos[lane] = 6 - t - pos[(lane + 2) % 3];
            }
        }
        return res;
    }
};