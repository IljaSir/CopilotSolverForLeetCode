class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        
        int ans = Integer.MIN_VALUE;
        int n = points.length;
        Deque<Integer> dq = new ArrayDeque<>();
        dq.addLast(0);
        for(int i = 1; i < n; i++) {
            while(!dq.isEmpty() && points[i][0] - points[dq.getFirst()][0] > k) {
                dq.removeFirst();
            }
            if(!dq.isEmpty()) {
                ans = Math.max(ans, points[i][0] + points[i][1] + points[dq.getFirst()][1] - points[dq.getFirst()][0]);
            }
            while(!dq.isEmpty() && points[i][0] + points[i][1] >= points[dq.getLast()][0] + points[dq.getLast()][1]) {
                dq.removeLast();
            }
            dq.addLast(i);
        }
        return ans;
    }
}