class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        
        int n = times.length;
        int[][] events = new int[2 * n][3];
        for (int i = 0; i < n; i++) {
            events[2 * i] = new int[]{times[i][0], 0, i};
            events[2 * i + 1] = new int[]{times[i][1], 1, i};
        }
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        TreeSet<Integer> chairs = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            chairs.add(i);
        }
        Map<Integer, Integer> leave = new HashMap<>();
        for (int[] event : events) {
            int time = event[0], type = event[1], id = event[2];
            if (type == 0) {
                int seat = chairs.pollFirst();
                if (id == targetFriend) {
                    return seat;
                }
                leave.put(id, seat);
            } else {
                chairs.add(leave.get(id));
            }
        }
        throw null;
    }
}