class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        
        int mod = 1000000007;
        int[][] engineers = new int[n][2];
        for (int i = 0; i < n; i++) {
            engineers[i] = new int[]{efficiency[i], speed[i]};
        }
        Arrays.sort(engineers, (a, b) -> b[0] - a[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long res = 0, speedSum = 0;
        for (int[] engineer : engineers) {
            int curSpeed = engineer[1];
            pq.offer(curSpeed);
            speedSum += curSpeed;
            if (pq.size() > k) {
                speedSum -= pq.poll();
            }
            res = Math.max(res, speedSum * engineer[0]);
        }
        return (int) (res % mod);
    }
}