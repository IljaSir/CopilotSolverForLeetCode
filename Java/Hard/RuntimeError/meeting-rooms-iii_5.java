class Solution {
    public int mostBooked(int n, int[][] meetings) {
        
        int[] rooms = new int[n];
        for (int[] meeting : meetings) {
            rooms[meeting[0]]++;
            rooms[meeting[1]]--;
        }
        int max = 0;
        int maxIndex = 0;
        for (int i = 1; i < rooms.length; i++) {
            rooms[i] += rooms[i - 1];
            if (rooms[i] > max) {
                max = rooms[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}