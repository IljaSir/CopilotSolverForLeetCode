class Solution {
    public long maxPower(int[] stations, int r, int k) {
        
        int n = stations.length;
        int[] gaps = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            gaps[i] = stations[i + 1] - stations[i];
        }
        long left = 1;
        long right = 1_000_000_000;
        while (left < right) {
            long mid = (left + right + 1) / 2;
            if (check(gaps, r, k, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean check(int[] gaps, int r, int k, long mid) {
        long count = 0;
        for (int gap : gaps) {
            if (gap > 2 * r) {
                count += (gap - 2 * r + 2 * r - 1) / (2 * r + 1);
            }
            if (count > k) {
                return false;
            }
        }
        return true;
    }
}