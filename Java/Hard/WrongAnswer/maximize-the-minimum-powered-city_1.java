class Solution {
    public long maxPower(int[] stations, int r, int k) {
        
        int n = stations.length;
        int[] d = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            d[i] = stations[i + 1] - stations[i] - 1;
        }
        Arrays.sort(d);
        long sum = 0;
        for (int i = 0; i < n - 1 - r; i++) {
            sum += d[i];
        }
        long ans = stations[n - 1] - stations[0] + 1;
        for (int i = 0; i < n - 1; i++) {
            int len = stations[i + 1] - stations[i] - 1;
            if (len <= 2 * r) {
                long need = (long) (len + 1) * (len + 2) / 2 - (long) (len - r + 1) * (len - r + 2) / 2;
                if (need <= k) {
                    ans = Math.max(ans, stations[n - 1] - stations[0] + 1 + need);
                    k -= need;
                } else {
                    ans = Math.max(ans, stations[n - 1] - stations[0] + 1 + k);
                    break;
                }
            } else {
                long need = (long) (r + 1) * (r + 2) / 2;
                if (need <= k) {
                    ans = Math.max(ans, stations[n - 1] - stations[0] + 1 + need);
                    k -= need;
                } else {
                    ans = Math.max(ans, stations[n - 1] - stations[0] + 1 + k);
                    break;
                }
            }
        }
        return ans;
    }
}