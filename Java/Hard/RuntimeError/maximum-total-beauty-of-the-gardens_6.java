class Solution {
    public long maximumBeauty(int[] flowers, long newFlowers, int target, int full, int partial) {
        
        int n = flowers.length;
        int[] count = new int[n + 1];
        int[] sum = new int[n + 1];
        long res = 0;
        for (int i = 0; i < n; i++) {
            int f = flowers[i];
            count[f]++;
            sum[f] += f;
            if (f >= target) {
                res += full;
            } else {
                res += Math.min(f * partial, full);
            }
        }
        for (int i = 1; i <= n; i++) {
            count[i] += count[i - 1];
            sum[i] += sum[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            if (i >= target) {
                int remain = (int) (newFlowers - count[i - 1]);
                if (remain >= 0) {
                    res = Math.max(res, full * count[i] + partial * (sum[i - 1] + Math.min(remain, n - i + 1) * i));
                }
            } else {
                int remain = (int) (newFlowers - (count[i - 1] - count[target - 1]));
                if (remain >= 0) {
                    res = Math.max(res, full * count[i] + partial * (sum[i - 1] - sum[target - 1] + Math.min(remain, n - i + 1) * i));
                }
            }
        }
        return res;
    }
}