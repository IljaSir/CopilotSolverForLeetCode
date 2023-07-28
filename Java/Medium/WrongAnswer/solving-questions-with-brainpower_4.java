class Solution {
    public long mostPoints(int[][] questions) {
        
        Arrays.sort(questions, (a, b) -> a[1] - b[1]);
        long ans = 0, sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int[] q : questions) {
            pq.offer(q[0]);
            sum += q[0];
            if (pq.size() > q[1]) {
                sum -= pq.poll();
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}