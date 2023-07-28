class Solution {
    public long maximumBeauty(int[] flowers, long newFlowers, int target, int full, int partial) {
        
        long ans = 0;
        long[] cnt = new long[100001];
        for (int f : flowers) {
            cnt[f]++;
        }
        int min = 0;
        while (min < cnt.length && cnt[min] > 0) {
            min++;
        }
        for (int i = min; i < cnt.length; i++) {
            if (cnt[i] == 0) {
                continue;
            }
            long need = (target - i) * cnt[i];
            if (need <= newFlowers) {
                ans += cnt[i] * full;
                newFlowers -= need;
            } else {
                ans += newFlowers / (target - i) * full;
                newFlowers %= target - i;
            }
        }
        ans += newFlowers * partial;
        return ans;
    }
}