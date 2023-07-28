class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        
        int n = points.length;
        int max = Integer.MIN_VALUE;
        Deque<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!q.isEmpty() && points[i][0] - q.peekFirst()[1] > k) {
                q.pollFirst();
            }
            if (!q.isEmpty()) {
                max = Math.max(max, points[i][0] + points[i][1] + q.peekFirst()[0]);
            }
            while (!q.isEmpty() && points[i][1] - points[i][0] >= q.peekLast()[0]) {
                q.pollLast();
            }
            q.offerLast(new int[]{points[i][1] - points[i][0], points[i][0]});
        }
        return max;
    }
}