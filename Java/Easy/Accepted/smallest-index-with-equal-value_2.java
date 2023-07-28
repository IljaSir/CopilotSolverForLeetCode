class Solution {
    public int smallestEqual(int[] nums) {
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i % 10) {
                min = Math.min(min, i);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}