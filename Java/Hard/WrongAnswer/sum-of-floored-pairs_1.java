class Solution {
    public int sumOfFlooredPairs(int[] nums) {
        
        int max = 0;
        for (int n : nums) {
            max = Math.max(max, n);
        }
        int[] count = new int[max + 1];
        for (int n : nums) {
            count[n]++;
        }
        int[] sum = new int[max + 1];
        for (int i = 1; i <= max; i++) {
            for (int j = i; j <= max; j += i) {
                sum[i] += count[j];
            }
        }
        for (int i = 1; i <= max; i++) {
            sum[i] += sum[i - 1];
        }
        long res = 0;
        for (int n : nums) {
            res += sum[n];
        }
        return (int) (res % 1_000_000_007);
    }
}