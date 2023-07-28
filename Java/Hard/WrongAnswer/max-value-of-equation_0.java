class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        
        int n = points.length;
        int res = Integer.MIN_VALUE;
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!q.isEmpty() && points[i][0] - points[q.peekFirst()][0] > k) {
                q.pollFirst();
            }
            if (!q.isEmpty()) {
                res = Math.max(res, points[i][0] + points[i][1] + points[q.peekFirst()][1] - points[q.peekFirst()][0]);
            }
            while (!q.isEmpty() && points[i][0] + points[i][1] - points[q.peekLast()][0] > points[i][0] + points[i][1] - points[q.peekLast()][1]) {
                q.pollLast();
            }
            q.offer(i);
        }
        return res;
    }
}