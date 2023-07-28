class Solution {
    public int maxEvents(int[][] events) {
        
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int res = 0, i = 0, n = events.length;
        for (int d = 1; d <= 100000; d++) {
            while (!pq.isEmpty() && pq.peek() < d) pq.poll();
            while (i < n && events[i][0] == d) {
                pq.offer(events[i++][1]);
            }
            if (!pq.isEmpty()) {
                pq.poll();
                res++;
            }
        }
        return res;
    }
}