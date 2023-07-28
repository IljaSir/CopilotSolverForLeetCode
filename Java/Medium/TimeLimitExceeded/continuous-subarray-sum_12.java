class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        
        if (nums.length < 2) return false;
        if (k == 0) {
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == 0 && nums[i-1] == 0) return true;
            }
            return false;
        }
        if (k < 0) k = -k;
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i-1] + nums[i];
            if (sums[i] % k == 0) return true;
        }
        for (int i = 1; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((sums[j] - sums[i-1]) % k == 0) return true;
            }
        }
        return false;
    }
}