class Solution {
public:
    int findCrossingTime(int n, int k, vector<vector<int>>& time) {
        
        vector<int> leftToRight(k);
        vector<int> pickOld(k);
        vector<int> rightToLeft(k);
        vector<int> putNew(k);
        for (int i = 0; i < k; ++i) {
            leftToRight[i] = time[i][0];
            pickOld[i] = time[i][1];
            rightToLeft[i] = time[i][2];
            putNew[i] = time[i][3];
        }
        vector<int> worker(k);
        vector<int> box(k);
        int left = 0;
        int right = 0;
        int cur = 0;
        int res = 0;
        while (left < k || right < k || cur > 0) {
            int next = INT_MAX;
            for (int i = 0; i < k; ++i) {
                if (box[i] < n) {
                    next = min(next, leftToRight[i] + rightToLeft[i]);
                }
            }
            for (int i = 0; i < k; ++i) {
                if (box[i] < n) {
                    if (leftToRight[i] + rightToLeft[i] == next) {
                        next = min(next, leftToRight[i] + rightToLeft[i] + pickOld[i]);
                        break;
                    }
                }
            }
            for (int i = 0; i < k; ++i) {
                if (box[i] < n) {
                    if (leftToRight[i] + rightToLeft[i] == next) {
                        if (worker[i] == 0) {
                            worker[i] = 1;
                            ++cur;
                            next = min(next, leftToRight[i] + rightToLeft[i] + pickOld[i]);
                            break;
                        }
                    }
                }
            }
            for (int i = 0; i < k; ++i) {
                if (box[i] < n) {
                    if (leftToRight[i] + rightToLeft[i] + pickOld[i] == next) {
                        next = min(next, leftToRight[i] + rightToLeft[i] + pickOld[i] + putNew[i]);
                        break;
                    }
                }
            }
            for (int i = 0; i < k; ++i) {
                if (box[i] < n) {
                    if (leftTo
    }
};