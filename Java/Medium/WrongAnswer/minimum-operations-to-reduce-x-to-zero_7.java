class Solution {
    public int minOperations(int[] nums, int x) {
        
        int n = nums.length;
        int[] preSum = new int[n+1];
        for(int i = 1; i <= n; i++) {
            preSum[i] = preSum[i-1] + nums[i-1];
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i <= n; i++) {
            int target = preSum[n] - x + preSum[i];
            int index = Arrays.binarySearch(preSum, target);
            if(index >= 0) {
                ans = Math.min(ans, i + n - index);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}