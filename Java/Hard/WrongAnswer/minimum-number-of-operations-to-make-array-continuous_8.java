class Solution {
    public int minOperations(int[] nums) {
        
        Arrays.sort(nums);
        int minOp = nums.length;
        int i = 0;
        int j = 0;
        int n = nums.length;
        while (j < n) {
            while (j < n && nums[j] - nums[i] < n) {
                j++;
            }
            if (j - i == n - 1 && nums[j - 1] - nums[i] == n - 1) {
                return 0;
            }
            minOp = Math.min(minOp, n - (j - i));
            i++;
        }
        return minOp;
    }
}