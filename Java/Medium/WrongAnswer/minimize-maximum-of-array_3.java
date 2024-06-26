class Solution {
    public int minimizeArrayValue(int[] nums) {
        
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            sum += num;
            min = Math.min(min, num);
        }
        return sum - min * nums.length;
    }
}