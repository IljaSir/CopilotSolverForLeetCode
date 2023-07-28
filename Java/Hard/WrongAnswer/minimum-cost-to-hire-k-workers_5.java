class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        
        int n = quality.length;
        int[][] workers = new int[n][2];
        for (int i = 0; i < n; i++) {
            workers[i][0] = quality[i];
            workers[i][1] = wage[i];
        }
        Arrays.sort(workers, (a, b) -> (a[1] * b[0] - a[0] * b[1]));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int sumq = 0;
        double res = Double.MAX_VALUE;
        for (int[] worker : workers) {
            pq.add(worker[0]);
            sumq += worker[0];
            if (pq.size() > k) {
                sumq -= pq.poll();
            }
            if (pq.size() == k) {
                res = Math.min(res, sumq * worker[1] * 1.0 / worker[0]);
            }
        }
        return res;
    }
}