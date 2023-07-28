class Solution {
    public long zeroFilledSubarray(int[] nums) {
        
        int[] prefixSum = new int[nums.length+1];
        for (int i = 1; i <= nums.length; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i-1];
        }
        long ans = 0;
        int[] count = new int[nums.length+1];
        for (int i = 0; i <= nums.length; i++) {
            ans += count[prefixSum[i]];
            count[prefixSum[i]]++;
        }
        return ans;
    }
}