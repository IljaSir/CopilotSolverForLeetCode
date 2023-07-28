class Solution {
public:
    int minimumFinishTime(vector<vector<int>>& tires, int changeTime, int numLaps) {
        
        int n = tires.size();
        vector<int> minTime(n, 0);
        for (int i = 0; i < n; i++) {
            int f = tires[i][0], r = tires[i][1];
            int t = f;
            for (int j = 1; j < numLaps; j++) {
                t += f * pow(r, j);
            }
            minTime[i] = t;
        }
        int ans = INT_MAX;
        for (int i = 0; i < n; i++) {
            int t = minTime[i];
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    int x = numLaps;
                    int y = minTime[j];
                    int z = changeTime;
                    int c = 0;
                    while (x > 1) {
                        if (y > t) {
                            t += z;
                            c++;
                        } else {
                            t += y;
                            c++;
                            y += z;
                            x--;
                        }
                    }
                    t += y;
                    c++;
                    ans = min(ans, t);
                    t = minTime[i];
                }
            }
        }
        return ans;
    }
};