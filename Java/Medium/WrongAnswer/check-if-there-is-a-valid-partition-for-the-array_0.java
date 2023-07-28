class Solution {
    public boolean validPartition(int[] nums) {
        
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        int[] suffix = new int[n];
        suffix[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + nums[i];
        }
        for (int i = 1; i < n - 1; i++) {
            if (prefix[i] % 2 == 0 && prefix[i] == prefix[i - 1] * 2) {
                return true;
            }
            if (suffix[i] % 2 == 0 && suffix[i] == suffix[i + 1] * 2) {
                return true;
            }
        }
        return false;
    }
}