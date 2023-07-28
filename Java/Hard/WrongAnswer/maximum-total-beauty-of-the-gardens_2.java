class Solution {
    public long maximumBeauty(int[] flowers, long newFlowers, int target, int full, int partial) {
        
        int n = flowers.length;
        long[] preSum = new long[n+1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i-1] + flowers[i-1];
        }
        long ans = 0;
        for (int i = 0; i <= n; i++) {
            int j = i;
            long sum = 0;
            int cnt = 0;
            while (j < n) {
                int k = j + 1;
                while (k < n && flowers[k] < target) {
                    k++;
                }
                if (k == n && flowers[n-1] < target) {
                    break;
                }
                long curSum = preSum[k] - preSum[j];
                long curNewFlowers = newFlowers - (j - i) * target - curSum;
                if (curNewFlowers >= 0) {
                    cnt += k - j;
                    sum += curSum;
                    j = k;
                } else {
                    break;
                }
            }
            if (j < n) {
                long curNewFlowers = newFlowers - (j - i) * target - sum;
                if (curNewFlowers >= 0) {
                    cnt += (curNewFlowers / target) + (curNewFlowers % target > 0 ? 1 : 0);
                }
            }
            ans = Math.max(ans, cnt * full + (n - cnt) * partial);
        }
        return ans;
    }
}