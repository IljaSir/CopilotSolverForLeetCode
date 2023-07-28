class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        
        int n = quality.length;
        double[][] workers = new double[n][2];
        for (int i = 0; i < n; ++i)
            workers[i] = new double[]{(double) (wage[i]) / quality[i], (double) quality[i]};
        Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0]));
        PriorityQueue<Integer> pool = new PriorityQueue<Integer>((a, b) -> Integer.compare(b, a));
        int sumq = 0;
        double ans = 1e9;
        for (double[] worker: workers) {
            sumq += worker[1];
            pool.add((int) worker[1]);
            if (pool.size() > k)
                sumq -= pool.poll();
            if (pool.size() == k)
                ans = Math.min(ans, sumq * worker[0]);
        }
        return ans;
    }
}