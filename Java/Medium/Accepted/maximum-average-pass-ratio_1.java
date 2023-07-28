class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            double r1 = (double)(a[0] + 1) / (a[1] + 1) - (double)a[0] / a[1];
            double r2 = (double)(b[0] + 1) / (b[1] + 1) - (double)b[0] / b[1];
            return r2 > r1 ? 1 : -1;
        });
        for (int[] c : classes) {
            pq.add(c);
        }
        while (extraStudents-- > 0) {
            int[] c = pq.poll();
            c[0]++;
            c[1]++;
            pq.add(c);
        }
        double res = 0;
        while (!pq.isEmpty()) {
            int[] c = pq.poll();
            res += (double)c[0] / c[1];
        }
        return res / classes.length;
    }
}