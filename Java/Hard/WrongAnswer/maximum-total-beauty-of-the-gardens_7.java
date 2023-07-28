class Solution {
    public long maximumBeauty(int[] flowers, long newFlowers, int target, int full, int partial) {
        
        int n = flowers.length;
        int[] cnt = new int[100001];
        long res = 0;
        for (int f : flowers) {
            cnt[f]++;
        }
        for (int i = 1; i <= 100000; i++) {
            long cur = 0;
            long rem = newFlowers;
            for (int j = i; j <= 100000; j += i) {
                long can = (target - cnt[j]) * i;
                long use = Math.min(rem, can);
                cur += use;
                rem -= use;
            }
            res = Math.max(res, (cur / i) * full + (cur % i) * partial);
        }
        return res;
    }
}