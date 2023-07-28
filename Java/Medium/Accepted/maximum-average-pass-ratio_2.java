class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        for (int[] c : classes) {
            double pass = c[0];
            double total = c[1];
            double gain = (pass + 1) / (total + 1) - pass / total;
            pq.add(new double[]{gain, pass, total});
        }
        for (int i = 0; i < extraStudents; i++) {
            double[] c = pq.poll();
            c[1]++;
            c[2]++;
            c[0] = (c[1] + 1) / (c[2] + 1) - c[1] / c[2];
            pq.add(c);
        }
        double res = 0;
        while (!pq.isEmpty()) {
            double[] c = pq.poll();
            res += c[1] / c[2];
        }
        return res / classes.length;
    }
}