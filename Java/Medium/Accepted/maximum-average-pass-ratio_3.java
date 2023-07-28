class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> {
            double x = (double)(a[0] + 1) / (a[1] + 1) - (double)a[0] / a[1];
            double y = (double)(b[0] + 1) / (b[1] + 1) - (double)b[0] / b[1];
            return Double.compare(y, x);
        });
        
        for (int[] c: classes) {
            pq.add(c);
        }
        
        for (int i = 0; i < extraStudents; i++) {
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