class Solution {
public:
    int maxSumTwoNoOverlap(vector<int>& nums, int firstLen, int secondLen) {
        
        int n = nums.size();
        int sum[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                sum[i] = nums[i];
            } else {
                sum[i] = sum[i - 1] + nums[i];
            }
        }
        int leftMax = 0;
        int rightMax = 0;
        int ans = 0;
        for (int i = firstLen - 1; i < n - secondLen; i++) {
            leftMax = max(leftMax, sum[i] - (i - firstLen >= 0 ? sum[i - firstLen] : 0));
            rightMax = sum[n - 1] - sum[i] - (n - i - secondLen - 1 >= 0 ? sum[n - i - secondLen - 1] : 0);
            ans = max(ans, leftMax + rightMax);
        }
        leftMax = 0;
        rightMax = 0;
        for (int i = secondLen - 1; i < n - firstLen; i++) {
            leftMax = max(leftMax, sum[i] - (i - secondLen >= 0 ? sum[i - secondLen] : 0));
            rightMax = sum[n - 1] - sum[i] - (n - i - firstLen - 1 >= 0 ? sum[n - i - firstLen - 1] : 0);
            ans = max(ans, leftMax + rightMax);
        }
        return ans;
    }
};