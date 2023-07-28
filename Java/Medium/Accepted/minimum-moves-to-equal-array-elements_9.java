class Solution {
    public int minMoves(int[] nums) {
        
        int min = nums[0];
        for (int num : nums) {
            min = Math.min(min, num);
        }
        int sum = 0;
        for (int num : nums) {
            sum += num - min;
        }
        return sum;
    }
}