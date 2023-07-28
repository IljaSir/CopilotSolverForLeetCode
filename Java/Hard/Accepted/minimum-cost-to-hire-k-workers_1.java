class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        
        int n = quality.length;
        int[][] workers = new int[n][2];
        for (int i = 0; i < n; ++i)
            workers[i] = new int[]{wage[i], quality[i]};
        Arrays.sort(workers, (w1, w2) -> Double.compare(w1[0] * 1.0 / w1[1], w2[0] * 1.0 / w2[1]));
        double res = Double.MAX_VALUE, qsum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> Integer.compare(i2, i1));
        for (int[] worker: workers) {
            pq.offer(worker[1]);
            qsum += worker[1];
            if (pq.size() > k)
                qsum -= pq.poll();
            if (pq.size() == k)
                res = Math.min(res, qsum * worker[0] * 1.0 / worker[1]);
        }
        return res;
    }
}