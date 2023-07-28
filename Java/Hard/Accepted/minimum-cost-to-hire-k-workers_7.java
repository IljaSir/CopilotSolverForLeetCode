class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        
        int n = quality.length;
        double[][] workers = new double[n][2];
        for (int i = 0; i < n; ++i) {
            workers[i] = new double[]{(double) (wage[i]) / quality[i], (double) quality[i]};
        }
        Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0]));
        double ans = Double.MAX_VALUE, qsum = 0;
        PriorityQueue<Double> pool = new PriorityQueue<>();
        for (double[] worker: workers) {
            qsum += worker[1];
            pool.offer(-worker[1]);
            if (pool.size() > k) {
                qsum += pool.poll();
            }
            if (pool.size() == k) {
                ans = Math.min(ans, qsum * worker[0]);
            }
        }
        return ans;
    }
}