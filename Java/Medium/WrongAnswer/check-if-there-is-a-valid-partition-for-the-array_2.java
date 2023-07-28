class Solution {
    public boolean validPartition(int[] nums) {
        
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            prefix[i] = prefix[i - 1] ^ nums[i];
        }
        int[] suffix = new int[n];
        suffix[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            suffix[i] = suffix[i + 1] ^ nums[i];
        }
        for (int i = 0; i < n - 1; ++i) {
            if (prefix[i] == 0) {
                for (int j = i + 1; j < n - 1; ++j) {
                    if (prefix[j] == 0 && suffix[j + 1] == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}