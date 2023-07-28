class Solution {
    public int maxScore(int[] nums) {
        
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            prefix[i] = sum;
        }
        sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum += nums[i];
            suffix[i] = sum;
        }
        int max = 0;
        for (int i = 0; i < n - 1; i++) {
            if (prefix[i] > 0) {
                max++;
            }
            if (suffix[i + 1] > 0) {
                max++;
            }
        }
        if (prefix[n - 1] > 0) {
            max++;
        }
        return max;
    }
}