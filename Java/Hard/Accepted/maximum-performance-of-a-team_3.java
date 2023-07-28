class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        
        int[][] engineers = new int[n][2];
        for (int i = 0; i < n; i++) {
            engineers[i][0] = efficiency[i];
            engineers[i][1] = speed[i];
        }
        Arrays.sort(engineers, (a, b) -> b[0] - a[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sum = 0;
        long result = 0;
        for (int[] engineer : engineers) {
            int e = engineer[0];
            int s = engineer[1];
            pq.offer(s);
            sum += s;
            if (pq.size() > k) {
                sum -= pq.poll();
            }
            result = Math.max(result, sum * e);
        }
        return (int) (result % 1000000007);
    }
}