class Solution {
public:
    int minimumAverageDifference(vector<int>& nums) {
        
        int n = nums.size();
        int sum[100001];
        sum[0] = 0;
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        int ans = 0;
        int minDiff = INT_MAX;
        for (int i = 0; i < n - 1; i++) {
            int left = (i + 1) / 2;
            int right = (i + 1) - left;
            int leftSum = sum[left];
            int rightSum = sum[i + 1] - sum[left];
            int leftAvg = leftSum / left;
            int rightAvg = rightSum / right;
            int diff = abs(leftAvg - rightAvg);
            if (diff < minDiff) {
                minDiff = diff;
                ans = i;
            }
        }
        return ans;
    }
};