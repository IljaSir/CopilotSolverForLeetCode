class Solution {
public:
    int minimumAverageDifference(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> presum(n + 1, 0);
        for (int i = 0; i < n; ++i) {
            presum[i + 1] = presum[i] + nums[i];
        }
        vector<int> minPre(n + 1, 0);
        for (int i = 0; i < n; ++i) {
            minPre[i + 1] = min(minPre[i], presum[i + 1]);
        }
        int ans = 0;
        double minAvg = 1e9;
        for (int i = 0; i < n; ++i) {
            double avg = (presum[n] - presum[i + 1]) * 1.0 / (n - i - 1);
            double avg2 = (presum[i + 1] - minPre[i + 1]) * 1.0 / (i + 1);
            double curAvg = min(avg, avg2);
            if (curAvg < minAvg) {
                minAvg = curAvg;
                ans = i;
            }
        }
        return ans;
    }
};