class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        
        int[] subordinates = new int[n];
        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                subordinates[manager[i]]++;
            }
        }
        int[] time = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(headID);
        while (!queue.isEmpty()) {
            int id = queue.poll();
            if (subordinates[id] == 0) {
                continue;
            }
            int t = time[id] + informTime[id];
            for (int i = 0; i < n; i++) {
                if (manager[i] == id) {
                    time[i] = t;
                    queue.add(i);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (subordinates[i] == 0) {
                max = Math.max(max, time[i]);
            }
        }
        return max;
    }
}