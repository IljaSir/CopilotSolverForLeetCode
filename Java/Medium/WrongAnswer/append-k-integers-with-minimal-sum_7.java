class Solution {
    public long minimalKSum(int[] nums, int k) {
        
        long result = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            result += nums[i];
            if (i > 0) {
                int diff = nums[i] - nums[i - 1];
                if (diff > 1) {
                    int n = Math.min(diff - 1, k);
                    k -= n;
                    result += (n * (long)nums[i - 1] + n * (long)(n + 1) / 2);
                }
            }
        }
        result += (k * (long)nums[nums.length - 1] + k * (long)(k + 1) / 2);
        return result;
    }
}