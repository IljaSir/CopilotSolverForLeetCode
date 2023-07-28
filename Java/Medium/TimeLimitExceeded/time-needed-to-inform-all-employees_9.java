class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        
        int[] time = new int[n];
        int[] subordinates = new int[n];
        for(int i = 0; i < n; i++) {
            if(manager[i] == -1) continue;
            subordinates[manager[i]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(headID);
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            if(subordinates[cur] == 0) continue;
            for(int i = 0; i < n; i++) {
                if(manager[i] == cur) {
                    time[i] = time[cur] + informTime[cur];
                    queue.offer(i);
                }
            }
        }
        int max = 0;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, time[i]);
        }
        return max;
    }
}