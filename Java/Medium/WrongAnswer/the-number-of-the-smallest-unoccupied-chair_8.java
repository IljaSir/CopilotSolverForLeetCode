class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        
        int n = times.length;
        int[] chairs = new int[n];
        for (int i = 0; i < n; i++) {
            chairs[i] = i;
        }
        int[][] events = new int[2 * n][3];
        for (int i = 0; i < n; i++) {
            events[2 * i] = new int[]{times[i][0], 0, i};
            events[2 * i + 1] = new int[]{times[i][1], 1, i};
        }
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        Set<Integer> occupied = new HashSet<>();
        for (int[] event : events) {
            if (event[1] == 0) {
                if (event[2] == targetFriend) {
                    return chairs[0];
                }
                occupied.add(chairs[0]);
                chairs = Arrays.copyOfRange(chairs, 1, chairs.length);
            } else {
                chairs = Arrays.copyOf(chairs, chairs.length + 1);
                chairs[chairs.length - 1] = event[2];
                Arrays.sort(chairs);
            }
        }
        return -1;
    }
}