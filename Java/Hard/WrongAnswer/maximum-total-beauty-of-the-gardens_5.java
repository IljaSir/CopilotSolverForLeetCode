class Solution {
    public long maximumBeauty(int[] flowers, long newFlowers, int target, int full, int partial) {
        
        int n = flowers.length;
        int[] cnt = new int[100001];
        for (int flower : flowers) {
            cnt[flower]++;
        }
        long[] sum = new long[100001];
        for (int i = 1; i <= 100000; i++) {
            sum[i] = sum[i - 1] + i * cnt[i];
        }
        long ans = 0;
        for (int i = target; i <= 100000; i++) {
            long x = newFlowers - (i * cnt[i] - sum[i]);
            if (x >= 0) {
                ans = Math.max(ans, (n - cnt[i]) * partial + full * i);
            }
        }
        return ans;
    }
}