class Solution {
    public int minimizeArrayValue(int[] nums) {
        
        int sum = 0, max = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        return (sum + nums.length - 2) / (nums.length - 1);
    }
}