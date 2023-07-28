class Solution {
    public long countPairs(int[] nums, int k) {
        
        long res = 0;
        int[] count = new int[k];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % k == 0) {
                res += count[0];
            }
            else {
                res += count[k - nums[i] % k];
            }
            count[nums[i] % k]++;
        }
        return res;
    }
}