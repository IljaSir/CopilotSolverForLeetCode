class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        
        int n = times.length;
        int[][] events = new int[n * 2][3];
        for (int i = 0; i < n; i++) {
            events[2 * i][0] = times[i][0];
            events[2 * i][1] = i;
            events[2 * i][2] = 1;
            events[2 * i + 1][0] = times[i][1];
            events[2 * i + 1][1] = i;
            events[2 * i + 1][2] = -1;
        }
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            set.add(i);
        }
        int[] chairs = new int[n];
        Arrays.fill(chairs, -1);
        for (int[] e : events) {
            int time = e[0];
            int id = e[1];
            int type = e[2];
            if (type == 1) {
                chairs[id] = set.pollFirst();
            } else {
                set.add(chairs[id]);
            }
            if (id == targetFriend) {
                return chairs[id];
            }
        }
        return -1;
    }
}