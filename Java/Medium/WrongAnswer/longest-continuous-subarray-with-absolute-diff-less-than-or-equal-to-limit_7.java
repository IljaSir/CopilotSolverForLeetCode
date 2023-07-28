class Solution {
    public int longestSubarray(int[] nums, int limit) {
        
        int n = nums.length;
        int[] min = new int[n];
        int[] max = new int[n];
        int p = 0, q = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            while (p > 0 && nums[i] < min[p - 1]) {
                p--;
            }
            while (q > 0 && nums[i] > max[q - 1]) {
                q--;
            }
            min[p] = nums[i];
            max[q] = nums[i];
            p++;
            q++;
            if (max[0] - min[0] > limit) {
                if (nums[i - p + 1] == min[0]) {
                    p--;
                }
                if (nums[i - q + 1] == max[0]) {
                    q--;
                }
            }
            res = Math.max(res, i - p + 2);
        }
        return res;
    }
}