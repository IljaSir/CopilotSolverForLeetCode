class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        
        Deque<Integer> queue = new LinkedList<>();
        int n = points.length;
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            while(!queue.isEmpty() && points[i][0] - points[queue.peek()][0] > k){
                queue.poll();
            }
            if(!queue.isEmpty()){
                ans = Math.max(ans, points[i][0] + points[i][1] + points[queue.peek()][1] - points[queue.peek()][0]);
            }
            while(!queue.isEmpty() && points[i][1] - points[i][0] > points[queue.peekLast()][1] - points[queue.peekLast()][0]){
                queue.pollLast();
            }
            queue.offer(i);
        }
        return ans;
    }
}