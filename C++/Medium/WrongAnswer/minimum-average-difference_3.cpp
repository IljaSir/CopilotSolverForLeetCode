class Solution {
public:
    int minimumAverageDifference(vector<int>& nums) {
        
        int n = nums.size();
        int sum[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        int ans = 0;
        int minDiff = INT_MAX;
        for (int i = 0; i < n - 1; i++) {
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                int leftSum = sum[mid] - sum[i];
                int rightSum = sum[n - 1] - sum[mid];
                int leftCount = mid - i;
                int rightCount = n - mid;
                int diff = abs(leftSum / leftCount - rightSum / rightCount);
                if (diff < minDiff) {
                    minDiff = diff;
                    ans = i;
                }
                if (leftSum * rightCount < rightSum * leftCount) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }
        return ans;
    }
};