class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        
        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b) -> Double.compare(b[0], a[0]));
        for (int[] c : classes) {
            double pass = c[0];
            double total = c[1];
            double ratio = (pass + 1) / (total + 1) - pass / total;
            pq.offer(new double[]{ratio, pass, total});
        }
        for (int i = 0; i < extraStudents; i++) {
            double[] c = pq.poll();
            c[1]++;
            c[2]++;
            double ratio = (c[1] + 1) / (c[2] + 1) - c[1] / c[2];
            pq.offer(new double[]{ratio, c[1], c[2]});
        }
        double sum = 0;
        while (!pq.isEmpty()) {
            double[] c = pq.poll();
            sum += c[1] / c[2];
        }
        return sum / classes.length;
    }
}