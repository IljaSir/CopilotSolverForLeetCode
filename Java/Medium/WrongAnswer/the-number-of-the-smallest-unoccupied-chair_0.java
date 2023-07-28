class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        
        int n = times.length;
        int[] arrival = new int[n];
        int[] leaving = new int[n];
        for (int i = 0; i < n; i++) {
            arrival[i] = times[i][0];
            leaving[i] = times[i][1];
        }
        Arrays.sort(arrival);
        Arrays.sort(leaving);
        int j = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            while (j < n && arrival[i] >= leaving[j]) {
                pq.add(j);
                j++;
            }
            if (i == targetFriend) {
                if (pq.isEmpty()) {
                    return j;
                } else {
                    return pq.poll();
                }
            }
        }
        return -1;
    }
}