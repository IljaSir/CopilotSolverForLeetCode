class Solution {
    public int maxEvents(int[][] events) {
        
        Arrays.sort(events, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0, res = 0, day = 1;
        while (i < events.length || !pq.isEmpty()) {
            while (i < events.length && events[i][0] == day)
                pq.offer(events[i++][1]);
            while (!pq.isEmpty() && pq.peek() < day)
                pq.poll();
            if (!pq.isEmpty()) {
                pq.poll();
                res++;
            }
            day++;
        }
        return res;
    }
}