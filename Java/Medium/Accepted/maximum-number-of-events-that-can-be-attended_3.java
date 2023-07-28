class Solution {
    public int maxEvents(int[][] events) {
        
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int ans = 0;
        int i = 0;
        for (int d = 1; d <= 100000; d++) {
            while (!pq.isEmpty() && pq.peek() < d) {
                pq.poll();
            }
            while (i < events.length && events[i][0] == d) {
                pq.offer(events[i][1]);
                i++;
            }
            if (!pq.isEmpty()) {
                pq.poll();
                ans++;
            }
        }
        return ans;
    }
}