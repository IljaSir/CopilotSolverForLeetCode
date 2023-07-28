class Solution {
    public int maxEvents(int[][] events) {
        
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0;
        int res = 0;
        for (int d = 1; d <= 100000; d++) {
            while (i < events.length && events[i][0] == d) {
                pq.add(events[i++][1]);
            }
            while (!pq.isEmpty() && pq.peek() < d) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                pq.poll();
                res++;
            }
        }
        return res;
    }
}