class Solution {
    public int sumOfFlooredPairs(int[] nums) {
        
        int[] counts = new int[100001];
        for (int num : nums) {
            counts[num]++;
        }
        int[] prefix = new int[100001];
        for (int i = 1; i < 100001; i++) {
            prefix[i] = prefix[i - 1] + counts[i];
        }
        long ans = 0;
        for (int i = 1; i < 100001; i++) {
            if (counts[i] == 0) {
                continue;
            }
            for (int j = 1; i * j < 100001; j++) {
                ans += (long) counts[i] * (prefix[Math.min(i * (j + 1) - 1, 100000)] - prefix[i * j - 1]);
            }
        }
        return (int) (ans % 1000000007);
    }
}