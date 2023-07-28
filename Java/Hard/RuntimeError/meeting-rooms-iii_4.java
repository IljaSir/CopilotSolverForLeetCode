class Solution {
    public int mostBooked(int n, int[][] meetings) {
        
        int[] rooms = new int[n];
        for (int[] meeting: meetings) {
            for (int i = meeting[0]; i < meeting[1]; i++) {
                rooms[i]++;
            }
        }
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < n; i++) {
            if (rooms[i] > max) {
                max = rooms[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}