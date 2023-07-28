class Solution {
    public int minMaxGame(int[] nums) {
        
        int n = nums.length;
        int[] newNums = new int[n / 2];
        for (int i = 0; i < n / 2; i++) {
            newNums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
        }
        if (n == 2) {
            return newNums[0];
        } else {
            return minMaxGame(newNums);
        }
    }
}