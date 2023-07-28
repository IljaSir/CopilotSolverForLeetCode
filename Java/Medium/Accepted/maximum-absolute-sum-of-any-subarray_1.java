class Solution {
    public int maxAbsoluteSum(int[] nums) {
        
        int max = 0;
        int min = 0;
        int sum = 0;
        for (int n : nums) {
            sum += n;
            max = Math.max(max, sum);
            min = Math.min(min, sum);
        }
        return max - min;
    }
}