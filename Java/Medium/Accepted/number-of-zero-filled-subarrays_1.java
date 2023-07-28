class Solution {
    public long zeroFilledSubarray(int[] nums) {
        
        long result = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            } else {
                result += (long) count * (count + 1) / 2;
                count = 0;
            }
        }
        result += (long) count * (count + 1) / 2;
        return result;
    }
}