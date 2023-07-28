class Solution {
public:
    int findCrossingTime(int n, int k, vector<vector<int>>& time) {
        
        int ans = 0;
        vector<int> t(k, 0);
        vector<int> pos(k, 0); // 0: left, 1: right
        vector<int> box(k, 0);
        while (n > 0) {
            for (int i = 0; i < k; ++i) {
                if (pos[i] == 0 && box[i] == 0) {
                    // move to right
                    pos[i] = 1;
                    t[i] += time[i][0];
                } else if (pos[i] == 1 && box[i] == 0) {
                    // pick up a box
                    box[i] = 1;
                    t[i] += time[i][1];
                    --n;
                } else if (pos[i] == 1 && box[i] == 1) {
                    // move to left
                    pos[i] = 0;
                    t[i] += time[i][2];
                } else if (pos[i] == 0 && box[i] == 1) {
                    // put down a box
                    box[i] = 0;
                    t[i] += time[i][3];
                }
            }
            // find the next worker to move
            int minTime = INT_MAX;
            int minWorker = -1;
            for (int i = 0; i < k; ++i) {
                if (t[i] < minTime) {
                    minTime = t[i];
                    minWorker = i;
                }
            }
            // update other workers' time
            for (int i = 0; i < k; ++i) {
                if (i != minWorker) {
                    t[i] = minTime;
                }
            }
            ans = max(ans, minTime);
        }
        return ans;
    }
    int minimumTimeRequired(vector<int>& jobs, int k) {
        int n = jobs.size();
        if (n == 0) {
            return 0;
        }
        if (k == 1) {
            return accumulate(jobs.begin(), jobs.end(), 0);
        }
        vector<vector<int>> time(k, vector<int>(4, 0));
        int ans = INT_MAX;
        for (int i = 0; i < (1 << n); ++i) {
            if (__builtin
    }
};