class Solution {
    public int countSubarrays(int[] nums, int k) {
        
        int[] count = new int[nums.length + 1];
        count[0] = 1;
        int res = 0, preSum = 0;
        for (int num : nums) {
            preSum += num < k ? -1 : 1;
            res += count[preSum];
            count[preSum]++;
        }
        return res;
    }
}