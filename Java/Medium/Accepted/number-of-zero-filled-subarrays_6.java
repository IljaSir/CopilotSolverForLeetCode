class Solution {
    public long zeroFilledSubarray(int[] nums) {
        
        long count = 0;
        int zeroCount = 0;
        for (int n : nums) {
            if (n == 0) {
                zeroCount++;
            } else {
                count += (long) zeroCount * (zeroCount + 1) / 2;
                zeroCount = 0;
            }
        }
        count += (long) zeroCount * (zeroCount + 1) / 2;
        return count;
    }
}