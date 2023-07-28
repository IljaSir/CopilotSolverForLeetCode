class Solution {
    public int maxAbsoluteSum(int[] nums) {
        
        int sum = 0;
        int max = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, Math.abs(sum));
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
}