class Solution {
    public int minimizeArrayValue(int[] nums) {
        
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int n = nums.length;
        return (sum + n - 2) / (n - 1);
    }
}