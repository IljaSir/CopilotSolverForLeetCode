class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0;
        while (i < n && k > 0) {
            if (nums[i] < 0) {
                nums[i] = -nums[i];
                k--;
            }
            i++;
        }
        if (k > 0) {
            if (k % 2 == 1) {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < n; j++) {
                    min = Math.min(min, nums[j]);
                }
                for (int j = 0; j < n; j++) {
                    if (nums[j] == min) {
                        nums[j] = -nums[j];
                        break;
                    }
                }
            }
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            res += nums[j];
        }
        return res;
    }
}