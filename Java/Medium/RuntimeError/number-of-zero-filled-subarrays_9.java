class Solution {
    public long zeroFilledSubarray(int[] nums) {
        
        int n = nums.length;
        int[] count = new int[n + 1];
        int sum = 0, res = 0;
        for (int num : nums) {
            sum += num;
            int i = sum - n;
            if (i >= 0) {
                res += count[i];
            }
            count[sum]++;
        }
        return (long) res + (long) count[0] * (long) (n + 1);
    }
}