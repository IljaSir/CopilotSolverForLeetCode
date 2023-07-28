class Solution {
    public int minMoves(int[] nums, int k) {
        
        int[] ones = new int[k];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                ones[j] = i;
                j++;
            }
        }
        int[] prefix = new int[k + 1];
        for (int i = 1; i <= k; i++) {
            prefix[i] = prefix[i - 1] + ones[i - 1];
        }
        int[] suffix = new int[k + 1];
        for (int i = k - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + nums.length - 1 - ones[i];
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= k; i++) {
            res = Math.min(res, prefix[i] + suffix[i + 1] - (k - i) * ones[i - 1]);
        }
        return res;
    }
}