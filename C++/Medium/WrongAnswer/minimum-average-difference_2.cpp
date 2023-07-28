class Solution {
public:
    int minimumAverageDifference(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> pre(n + 1);
        for (int i = 0; i < n; ++i) {
            pre[i + 1] = pre[i] + nums[i];
        }
        int res = 0;
        double minAvg = 1e9;
        for (int i = 0; i < n - 1; ++i) {
            int l = i + 1, r = n - 1;
            while (l <= r) {
                int m = l + (r - l) / 2;
                double avg1 = (pre[m + 1] - pre[0]) / (m + 1.0);
                double avg2 = (pre[n] - pre[m + 1]) / (n - m - 1.0);
                if (avg1 < avg2) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            int m = l - 1;
            double avg1 = (pre[m + 1] - pre[0]) / (m + 1.0);
            double avg2 = (pre[n] - pre[m + 1]) / (n - m - 1.0);
            if (minAvg > abs(avg1 - avg2)) {
                minAvg = abs(avg1 - avg2);
                res = i;
            }
        }
        return res;
    }
};