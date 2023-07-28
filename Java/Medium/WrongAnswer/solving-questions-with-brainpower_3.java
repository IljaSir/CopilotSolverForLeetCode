class Solution {
    public long mostPoints(int[][] questions) {
        
        Arrays.sort(questions, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        long res = 0, sum = 0;
        for (int[] q : questions) {
            pq.add(q[0]);
            sum += q[0];
            if (pq.size() > q[1]) {
                sum -= pq.poll();
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}