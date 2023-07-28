class Solution {
public:
    int findCrossingTime(int n, int k, vector<vector<int>>& time) {
        
        int ans = 0;
        int bridge = 0;
        int left = 0;
        int right = 0;
        int leftToRight = 0;
        int rightToLeft = 0;
        while (n) {
            if (bridge == 0) {
                if (right) {
                    ans += time[rightToLeft][2];
                    --right;
                    ++left;
                    bridge = 1;
                } else if (left) {
                    ans += time[leftToRight][0];
                    --left;
                    ++right;
                    bridge = 1;
                } else {
                    ans += time[leftToRight][0];
                    --left;
                    ++right;
                    bridge = 1;
                }
            } else {
                if (right) {
                    ans += time[rightToLeft][3];
                    --right;
                    --n;
                    bridge = 0;
                } else {
                    ans += time[leftToRight][1];
                    --left;
                    ++right;
                    bridge = 0;
                }
            }
            if (bridge == 0) {
                leftToRight = 0;
                rightToLeft = 0;
                for (int i = 1; i < k; ++i) {
                    if (leftToRight == 0 || time[i][0] + time[i][2] < time[leftToRight][0] + time[leftToRight][2] ||
                        (time[i][0] + time[i][2] == time[leftToRight][0] + time[leftToRight][2] && i < leftToRight)) {
                        leftToRight = i;
                    }
                    if (rightToLeft == 0 || time[i][2] + time[i][0] < time[rightToLeft][2] + time[rightToLeft][0] ||
                        (time[i][2] + time[i][0] == time[rightToLeft][2] + time[rightToLeft][0] && i < rightToLeft)) {
                        rightToLeft = i;
                    }
                }
            }
        }
        return ans;
    }
};