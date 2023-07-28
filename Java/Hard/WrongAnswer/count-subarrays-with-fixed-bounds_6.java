class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        
        long result = 0;
        int[] prefix = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = prefix[j + 1] - prefix[i];
                if (sum >= minK && sum <= maxK) {
                    result++;
                }
            }
        }
        return result;
    }
}