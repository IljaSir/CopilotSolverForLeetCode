class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        
        int[][] engineers = new int[n][2];
        for (int i = 0; i < n; i++) {
            engineers[i][0] = speed[i];
            engineers[i][1] = efficiency[i];
        }
        Arrays.sort(engineers, (a, b) -> b[1] - a[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long speedSum = 0;
        long maxPerformance = 0;
        for (int[] engineer : engineers) {
            int speedOfEngineer = engineer[0];
            int efficiencyOfEngineer = engineer[1];
            if (pq.size() > k - 1) {
                speedSum -= pq.poll();
            }
            pq.offer(speedOfEngineer);
            speedSum += speedOfEngineer;
            maxPerformance = Math.max(maxPerformance, speedSum * efficiencyOfEngineer);
        }
        return (int) (maxPerformance % (1000000000 + 7));
    }
}