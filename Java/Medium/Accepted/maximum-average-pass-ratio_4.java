class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        for (int[] c : classes) {
            pq.offer(new double[]{(double) (c[0] + 1) / (c[1] + 1) - (double) c[0] / c[1], c[0], c[1]});
        }
        while (extraStudents-- > 0) {
            double[] c = pq.poll();
            c[1]++;
            c[2]++;
            pq.offer(new double[]{(double) (c[1] + 1) / (c[2] + 1) - (double) c[1] / c[2], c[1], c[2]});
        }
        double res = 0;
        while (!pq.isEmpty()) {
            double[] c = pq.poll();
            res += (double) c[1] / c[2];
        }
        return res / classes.length;
    }
}