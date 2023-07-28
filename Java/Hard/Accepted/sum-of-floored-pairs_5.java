class Solution {
    public int sumOfFlooredPairs(int[] nums) {
        
        int[] count = new int[100001];
        for (int num : nums) {
            count[num]++;
        }
        int[] sum = new int[100001];
        for (int i = 1; i <= 100000; i++) {
            sum[i] = sum[i - 1] + count[i];
        }
        long ans = 0;
        for (int i = 1; i <= 100000; i++) {
            for (int j = i; j <= 100000; j += i) {
                ans += (long) (sum[Math.min(100000, j + i - 1)] - sum[j - 1]) * count[i] * (j / i);
            }
        }
        return (int) (ans % 1000000007);
    }
}