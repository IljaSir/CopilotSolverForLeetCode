class Solution {
    public int countSubarrays(int[] nums, int k) {
        
        int[] count = new int[nums.length + 1];
        int[] prefixSum = new int[nums.length + 1];
        count[0] = 1;
        int sum = 0;
        for (int num : nums) {
            sum += num < k ? -1 : 1;
            prefixSum[sum + nums.length]++;
        }
        int total = 0;
        for (int i = 0; i <= nums.length; i++) {
            total += prefixSum[i] * count[i];
            count[i] += prefixSum[i];
        }
        return total;
    }
}