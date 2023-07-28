class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        
        int n = dist.length;
        double[] times = new double[n];
        for (int i = 0; i < n; i++) {
            times[i] = (double) dist[i] / speed[i];
        }
        Arrays.sort(times);
        int ans = 0;
        for (double time : times) {
            if (time <= ans) {
                break;
            }
            ans++;
        }
        return ans;
    }
}