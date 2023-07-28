class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        
        int n = times.length;
        int[] friends = new int[n];
        for (int i = 0; i < n; i++) {
            friends[i] = i;
        }
        Arrays.sort(friends, (a, b) -> Integer.compare(times[a][0], times[b][0]));
        TreeSet<Integer> chairs = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            chairs.add(i);
        }
        TreeMap<Integer, Integer> leave = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int friend = friends[i];
            int time = times[friend][0];
            while (!leave.isEmpty() && leave.firstKey() <= time) {
                chairs.add(leave.pollFirstEntry().getValue());
            }
            if (friend == targetFriend) {
                return chairs.first();
            }
            chairs.remove(chairs.first());
            leave.put(times[friend][1], chairs.first());
        }
        return -1;
    }
}