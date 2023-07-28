class Solution {
    public long mostPoints(int[][] questions) {
        
        Arrays.sort(questions, (a, b) -> a[1] - b[1]);
        long total = 0;
        long result = 0;
        int N = questions.length;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i = 0; i < N; i++) {
            int points = questions[i][0];
            int brainpower = questions[i][1];
            while (pq.size() > brainpower) {
                total -= pq.poll();
            }
            pq.add(points);
            total += points;
            result = Math.max(result, total);
        }
        return result;
    }
}