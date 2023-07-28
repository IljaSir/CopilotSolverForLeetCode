class Solution {
    public long repairCars(int[] ranks, int cars) {
        
        int n = ranks.length;
        long l = 0, r = 1L * 1000000 * 1000000 * 100;
        while (l < r) {
            long m = l + (r - l) / 2;
            if (check(ranks, cars, m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
    boolean check(int[] ranks, int cars, long m) {
        long sum = 0;
        for (int i = ranks.length - 1; i >= 0; i--) {
            sum += Math.min(m / ranks[i], cars);
        }
        return sum >= cars;
    }
}