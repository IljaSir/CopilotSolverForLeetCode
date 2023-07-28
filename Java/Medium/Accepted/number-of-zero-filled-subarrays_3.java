class Solution {
    public long zeroFilledSubarray(int[] nums) {
        
        long count = 0;
        long zeroCount = 0;
        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
            } else {
                count += zeroCount * (zeroCount + 1) / 2;
                zeroCount = 0;
            }
        }
        count += zeroCount * (zeroCount + 1) / 2;
        return count;
    }
}