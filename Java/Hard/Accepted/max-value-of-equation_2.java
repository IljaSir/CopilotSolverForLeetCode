class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        
        int n = points.length;
        int ans = Integer.MIN_VALUE;
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(0);
        for (int i = 1; i < n; i++) {
            while (!dq.isEmpty() && points[i][0] - points[dq.peek()][0] > k) {
                dq.poll();
            }
            if (!dq.isEmpty()) {
                ans = Math.max(ans, points[i][0] + points[i][1] + points[dq.peek()][1] - points[dq.peek()][0]);
            }
            while (!dq.isEmpty() && points[i][1] - points[i][0] > points[dq.peekLast()][1] - points[dq.peekLast()][0]) {
                dq.pollLast();
            }
            dq.add(i);
        }
        return ans;
    }
}