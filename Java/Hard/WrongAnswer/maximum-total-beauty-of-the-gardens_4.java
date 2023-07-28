class Solution {
    public long maximumBeauty(int[] flowers, long newFlowers, int target, int full, int partial) {
        
        int n = flowers.length;
        long sum = 0;
        int cnt = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (flowers[i] >= target) {
                sum += full;
                cnt++;
            } else {
                min = Math.min(min, flowers[i]);
            }
        }
        if (newFlowers >= n * target) {
            return sum + (newFlowers - n * target) / target * full;
        }
        long res = sum + (n - cnt) * (long)min * partial;
        int[] cnts = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (flowers[i] < target) {
                cnts[flowers[i] % target]++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (cnts[i] == 0) {
                continue;
            }
            long t = sum + (n - cnt) * (long)i * partial;
            long x = newFlowers - (target - i);
            if (x < 0) {
                continue;
            }
            int c = 0;
            for (int j = n; j >= 0 && x > 0; j--) {
                if (j == i) {
                    continue;
                }
                int d = Math.min(cnts[j], (int)(x / (target - j)));
                c += d;
                x -= (long)(target - j) * d;
            }
            t += (long)c * full;
            res = Math.max(res, t);
        }
        return res;
    }
}