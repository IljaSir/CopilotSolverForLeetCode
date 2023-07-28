class Solution {
    public int maxEvents(int[][] events) {
        
        Arrays.sort(events, (a, b) -> a[1] - b[1]);
        int day = 0;
        int count = 0;
        int i = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while (i < events.length || !pq.isEmpty()) {
            if (pq.isEmpty()) {
                day = events[i][0];
            }
            while (i < events.length && events[i][0] <= day) {
                pq.offer(events[i][0]);
                i++;
            }
            pq.poll();
            day++;
            count++;
            while (!pq.isEmpty() && pq.peek() < day) {
                pq.poll();
            }
        }
        return count;
    }
}