class Solution {
    public int findLHS(int[] nums) {
        
        int n = nums.length;
        if (n < 2) return 0;
        Arrays.sort(nums);
        int max = 0;
        int i = 0;
        int j = 1;
        while (i < n && j < n) {
            if (nums[j] - nums[i] <= 1) {
                max = Math.max(max, j - i + 1);
                j++;
            } else {
                i++;
            }
        }
        return max;
    }
}