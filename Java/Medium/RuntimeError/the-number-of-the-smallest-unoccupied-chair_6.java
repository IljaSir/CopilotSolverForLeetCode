class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        
        int n = times.length;
        int[] chairs = new int[n];
        for (int i = 0; i < n; i++) {
            chairs[i] = i;
        }
        Arrays.sort(times, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int[] time : times) {
            while (!pq.isEmpty() && pq.peek()[1] <= time[0]) {
                chairs[pq.poll()[0]] = -1;
            }
            int i = 0;
            while (chairs[i] != -1) {
                i++;
            }
            chairs[i] = time[1];
            pq.offer(new int[] {i, time[1]});
        }
        for (int i = 0; i < n; i++) {
            if (times[i][0] == times[targetFriend][0] && times[i][1] == times[targetFriend][1]) {
                return i;
            }
        }
        return -1;
    }
}