class Solution {
public:
    int waysToSplit(vector<int>& nums) {
        
        int n = nums.size();
        int res = 0;
        vector<int> preSum(n, 0);
        preSum[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            preSum[i] = preSum[i-1] + nums[i];
        }
        for (int i = 0; i < n-2; ++i) {
            int leftSum = preSum[i];
            int leftMax = leftSum;
            int leftMin = leftSum;
            int rightMin = preSum[n-1] - leftSum;
            int rightMax = rightMin;
            int midMin = max(leftMin, preSum[i+1] - rightMax);
            int midMax = min(rightMin, preSum[n-1] - leftMax);
            if (midMin <= midMax) {
                int l = i + 1;
                int r = n - 1;
                while (l < r) {
                    int mid = l + (r - l) / 2;
                    if (preSum[mid] - leftSum >= midMin) {
                        r = mid;
                    } else {
                        l = mid + 1;
                    }
                }
                int left = l;
                l = i + 1;
                r = n - 1;
                while (l < r) {
                    int mid = l + (r - l) / 2;
                    if (preSum[mid] - leftSum <= midMax) {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }
                int right = l;
                res = (res + right - left) % 1000000007;
            }
        }
        return res;
    }
};