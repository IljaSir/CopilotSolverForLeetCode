class Solution {
    public long zeroFilledSubarray(int[] nums) {
        
        long total = 0;
        long count = 0;
        for (int n : nums) {
            if (n == 0) {
                count++;
            } else {
                total += count * (count + 1) / 2;
                count = 0;
            }
        }
        total += count * (count + 1) / 2;
        return total;
    }
}