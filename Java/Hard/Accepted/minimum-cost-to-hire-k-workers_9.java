class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        
        int n = quality.length;
        double[][] workers = new double[n][2];
        for (int i = 0; i < n; ++i) {
            workers[i][0] = (double) (wage[i]) / quality[i];
            workers[i][1] = quality[i];
        }
        Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0]));
        double ans = 1e9;
        int sumq = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (double[] worker : workers) {
            pq.offer((int) worker[1]);
            sumq += worker[1];
            if (pq.size() > k) {
                sumq -= pq.poll();
            }
            if (pq.size() == k) {
                ans = Math.min(ans, sumq * worker[0]);
            }
        }
        return ans;
    }
}