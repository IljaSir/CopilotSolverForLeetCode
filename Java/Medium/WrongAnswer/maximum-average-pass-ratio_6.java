class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0] / (double)b[1] - (b[0] + 1) / (double)(b[1] + 1), a[0] / (double)a[1] - (a[0] + 1) / (double)(a[1] + 1)));
        for (int[] c : classes) {
            pq.offer(c);
        }
        while (extraStudents-- > 0) {
            int[] c = pq.poll();
            c[0]++;
            c[1]++;
            pq.offer(c);
        }
        double res = 0.0;
        while (!pq.isEmpty()) {
            int[] c = pq.poll();
            res += c[0] / (double)c[1];
        }
        return res / classes.length;
    }
}