class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Double.compare((double) (b[0] + 1) / (b[1] + 1) - (double) b[0] / b[1], (double) (a[0] + 1) / (a[1] + 1) - (double) a[0] / a[1]));
        for (int[] c : classes) {
            pq.offer(c);
        }
        while (extraStudents-- > 0) {
            int[] cur = pq.poll();
            cur[0]++;
            cur[1]++;
            pq.offer(cur);
        }
        double ans = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            ans += (double) cur[0] / cur[1];
        }
        return ans / classes.length;
    }
}