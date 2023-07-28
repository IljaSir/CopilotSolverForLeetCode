class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        
        int[][] engineers = new int[n][2];
        for (int i = 0; i < n; i++) {
            engineers[i][0] = efficiency[i];
            engineers[i][1] = speed[i];
        }
        Arrays.sort(engineers, (a, b) -> b[0] - a[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long max = 0;
        long sum = 0;
        for (int[] engineer : engineers) {
            pq.offer(engineer[1]);
            sum += engineer[1];
            if (pq.size() > k) {
                sum -= pq.poll();
            }
            max = Math.max(max, sum * engineer[0]);
        }
        return (int) (max % 1000000007);
    }
}