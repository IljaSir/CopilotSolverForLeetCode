class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        
        int n = quality.length;
        double[][] workers = new double[n][2];
        for (int i = 0; i < n; i++) {
            workers[i][0] = (double)wage[i] / quality[i];
            workers[i][1] = quality[i];
        }
        Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0]));
        double ans = Double.MAX_VALUE, qualitySum = 0;
        PriorityQueue<Double> pq = new PriorityQueue<>();
        for (double[] worker: workers) {
            qualitySum += worker[1];
            pq.offer(-worker[1]);
            if (pq.size() > k) {
                qualitySum += pq.poll();
            }
            if (pq.size() == k) {
                ans = Math.min(ans, qualitySum * worker[0]);
            }
        }
        return ans;
    }
}