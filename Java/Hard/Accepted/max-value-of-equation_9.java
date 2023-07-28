class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        
        // y1 + y2 + |x1 - x2| = y1 - x1 + y2 + x2
        // y1 + y2 + x1 - x2 = y1 - x1 + y2 + x2
        int max = Integer.MIN_VALUE;
        Deque<int[]> queue = new ArrayDeque<>();
        for (int[] point : points) {
            while (!queue.isEmpty() && point[0] - queue.peekFirst()[0] > k) {
                queue.pollFirst();
            }
            if (!queue.isEmpty()) {
                max = Math.max(max, point[0] + point[1] + queue.peekFirst()[1] - queue.peekFirst()[0]);
            }
            while (!queue.isEmpty() && point[1] - point[0] >= queue.peekLast()[1] - queue.peekLast()[0]) {
                queue.pollLast();
            }
            queue.offerLast(point);
        }
        return max;
    }
}