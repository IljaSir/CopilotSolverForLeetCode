class Solution {
    public long mostPoints(int[][] questions) {
        
        Arrays.sort(questions, (a, b) -> a[1] - b[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        long res = 0, sum = 0;
        for (int i = 0; i < questions.length; i++) {
            pq.offer(questions[i]);
            sum += questions[i][0];
            while (pq.size() > questions[i][1]) {
                sum -= pq.poll()[0];
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}