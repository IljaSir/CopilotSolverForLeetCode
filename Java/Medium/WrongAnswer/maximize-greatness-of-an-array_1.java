class Solution {
    public int maximizeGreatness(int[] nums) {
        
        int n = nums.length;
        int[] max = new int[n];
        max[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            max[i] = Math.max(nums[i], max[i + 1]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] < max[i]) {
                res++;
            }
        }
        return res;
    }
}