class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        
        int n = nums.length;
        int[] ans = new int[k];
        if (n == 0) {
            return ans;
        }
        int i = 0;
        int j = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int maxI = -1;
        int maxJ = -1;
        while (j < n) {
            sum += nums[j];
            if (j - i + 1 == k) {
                if (sum > max) {
                    max = sum;
                    maxI = i;
                    maxJ = j;
                }
                sum -= nums[i];
                i++;
            }
            j++;
        }
        for (int l = maxI; l <= maxJ; l++) {
            ans[l - maxI] = nums[l];
        }
        return ans;
    }
}