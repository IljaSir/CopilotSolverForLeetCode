class Solution {
    public int longestSubarray(int[] nums, int limit) {
        
        int n = nums.length;
        int[] max = new int[n];
        int[] min = new int[n];
        int i = 0, j = 0;
        int ans = 0;
        for (int k = 0; k < n; k++) {
            int num = nums[k];
            while (i < j && num > max[j - 1]) j--;
            while (i < j && num < min[j - 1]) j--;
            max[j] = num;
            min[j] = num;
            j++;
            while (max[i] - min[i] > limit) i++;
            ans = Math.max(ans, j - i);
        }
        return ans;
    }
}