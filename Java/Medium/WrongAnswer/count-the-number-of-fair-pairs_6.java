class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        
        int n = nums.length;
        long[] preSum = new long[n+1];
        for(int i = 1; i <= n; i++) {
            preSum[i] = preSum[i-1] + nums[i-1];
        }
        long res = 0;
        for(int i = 0; i < n; i++) {
            long l = preSum[i] + lower, r = preSum[i] + upper;
            int left = i + 1, right = n;
            while(left < right) {
                int mid = left + (right - left) / 2;
                if(preSum[mid] >= l) right = mid;
                else left = mid + 1;
            }
            int lInd = left;
            left = i + 1;
            right = n;
            while(left < right) {
                int mid = left + (right - left) / 2;
                if(preSum[mid] <= r) left = mid + 1;
                else right = mid;
            }
            int rInd = right;
            res += rInd - lInd;
        }
        return res;
    }
}