class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        
        int min = Integer.MAX_VALUE;
        for (int i : numsDivide) {
            min = Math.min(min, i);
        }
        int count = 0;
        for (int i : nums) {
            if (min % i != 0) {
                count++;
            }
        }
        return count;
    }
}