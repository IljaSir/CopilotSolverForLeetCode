class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        
        int[][] events = new int[times.length * 2][3];
        for (int i = 0; i < times.length; ++i) {
            events[2 * i] = new int[]{times[i][0], 0, i};
            events[2 * i + 1] = new int[]{times[i][1], 1, i};
        }
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < times.length; ++i) {
            pq.offer(i);
        }
        int[] chair = new int[times.length];
        Arrays.fill(chair, -1);
        for (int i = 0; i < events.length; ++i) {
            int[] event = events[i];
            if (event[1] == 0) {
                chair[event[2]] = pq.poll();
            } else {
                pq.offer(chair[event[2]]);
            }
        }
        return chair[targetFriend];
    }
}