class Solution {
    public long repairCars(int[] ranks, int cars) {
        
        long l = 0;
        long r = 1000000000000000000L;
        while (l < r) {
            long m = (l + r) / 2;
            long c = 0;
            for (int i = 0; i < ranks.length; i++) {
                c += m / (ranks[i] * ranks[i]);
            }
            if (c < cars) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return lnt i = 0; i < n; i++) {
                cnt += Math.min(cars, mid / (ranks[i] * ranks[i]));
            }
            if (cnt >= cars) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}