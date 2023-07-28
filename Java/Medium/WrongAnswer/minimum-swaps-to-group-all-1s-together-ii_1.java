class Solution {
    public int minSwaps(int[] nums) {
        
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                count++;
            }
        }
        int res = 0;
        for (int i = 0; i < count; i++) {
            if (nums[i] == 0) {
                res++;
            }
        }
        int min = res;
        for (int i = 0, j = count; j < n; i++, j++) {
            if (nums[i] == 0) {
                res--;
            }
            if (nums[j] == 0) {
                res++;
            }
            min = Math.min(min, res);
        }
        return min;
    }
}