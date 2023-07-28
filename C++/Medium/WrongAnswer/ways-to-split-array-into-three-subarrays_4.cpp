class Solution {
public:
    int waysToSplit(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> preSum(n);
        preSum[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            preSum[i] = preSum[i-1] + nums[i];
        }
        int ans = 0;
        for (int i = 0; i < n-2; ++i) {
            int l = i+1;
            int r = n-1;
            while (l < r) {
                int mid = l + (r-l)/2;
                int left = preSum[i];
                int right = preSum[n-1] - preSum[mid];
                int midSum = preSum[mid] - preSum[i];
                if (left <= midSum && midSum <= right) {
                    r = mid;
                } else if (left > midSum) {
                    l = mid+1;
                } else {
                    r = mid;
                }
            }
            int left = preSum[i];
            int right = preSum[n-1] - preSum[r];
            int midSum = preSum[r] - preSum[i];
            if (left <= midSum && midSum <= right) {
                ans = (ans + n-r) % 1000000007;
            }
        }
        return ans;
    }
};