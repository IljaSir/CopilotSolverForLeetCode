class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
        double sum = 0;
        for (int[] cl : classes) {
            double pass = cl[0];
            double total = cl[1];
            double ratio = pass / total;
            double ratioDiff = (pass + 1) / (total + 1) - ratio;
            sum += ratio;
            pq.add(new double[]{total, ratioDiff});
        }
        while (extraStudents-- > 0) {
            double[] top = pq.poll();
            sum += top[1];
            double total = top[0];
            pq.add(new double[]{total, (top[0] + 2) / (top[0] + 1) - (top[0] + 1) / (top[0] + 1)});
        }
        return sum / classes.length;
    }
}