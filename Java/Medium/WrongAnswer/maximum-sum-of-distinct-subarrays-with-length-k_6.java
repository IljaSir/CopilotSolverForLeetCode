class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        
        int n = nums.length;
        long[] sum = new long[n+1];
        for(int i=0;i<n;i++) sum[i+1] = sum[i] + nums[i];
        long ans = 0;
        TreeSet<Long> set = new TreeSet<>();
        for(int i=k;i<=n;i++){
            set.add(sum[i-k]);
            ans = Math.max(ans, sum[i] - set.first());
        }
        return ans;
    }
}