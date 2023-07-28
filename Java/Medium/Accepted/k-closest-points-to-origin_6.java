class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        int[][] result = new int[k][2];
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]);
            }
        });
        for (int[] point : points) {
            pq.add(point);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int i = 0;
        while (!pq.isEmpty()) {
            result[i++] = pq.poll();
        }
        return result;
    }
}