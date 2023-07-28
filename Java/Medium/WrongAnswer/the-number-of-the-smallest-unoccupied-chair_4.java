class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        
        int n = times.length;
        int[][] sortedTimes = new int[n][3];
        for (int i = 0; i < n; i++) {
            sortedTimes[i][0] = times[i][0];
            sortedTimes[i][1] = times[i][1];
            sortedTimes[i][2] = i;
        }
        Arrays.sort(sortedTimes, (a, b) -> a[0] - b[0]);
        int[] chairs = new int[n];
        int[] occupied = new int[n];
        for (int i = 0; i < n; i++) {
            chairs[i] = i;
            occupied[i] = -1;
        }
        int chairIndex = 0;
        for (int i = 0; i < n; i++) {
            int friend = sortedTimes[i][2];
            int time = sortedTimes[i][0];
            while (occupied[chairIndex] != -1 && occupied[chairIndex] <= time) {
                occupied[chairIndex] = -1;
                chairIndex++;
            }
            occupied[chairIndex] = sortedTimes[i][1];
            if (friend == targetFriend) {
                return chairs[chairIndex];
            }
        }
        return -1;
    }
}