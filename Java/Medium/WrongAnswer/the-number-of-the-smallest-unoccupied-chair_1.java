class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        
        int n = times.length;
        int[] arrival = new int[n];
        int[] leave = new int[n];
        for (int i = 0; i < n; i++) {
            arrival[i] = times[i][0];
            leave[i] = times[i][1];
        }
        int[][] order = new int[n][2];
        for (int i = 0; i < n; i++) {
            order[i][0] = arrival[i];
            order[i][1] = i;
        }
        Arrays.sort(order, (a, b) -> a[0] - b[0]);
        int[] leaveOrder = new int[n];
        for (int i = 0; i < n; i++) {
            leaveOrder[i] = leave[order[i][1]];
        }
        Arrays.sort(leaveOrder);
        int[] chairs = new int[n];
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j < n && leaveOrder[j] <= arrival[order[i][1]]) {
                chairs[j] = 1;
                j++;
            }
            for (j = 0; j < n; j++) {
                if (chairs[j] == 0) {
                    chairs[j] = 1;
                    break;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (order[i][1] == targetFriend) {
                return j;
            }
        }
        return -1;
    }
}