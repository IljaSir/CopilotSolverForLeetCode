class Solution {
    public int maxScore(int[] nums) {
        
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
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (prefix[i] > 0) max++;
        }
        int res = max;
        for (int i = 0; i < n - 1; i++) {
            if (prefix[i] > 0) max--;
            if (suffix[i + 1] > 0) max++;
            res = Math.max(res, max);
        }
        return res;
    }
}