class Solution {
    public int mostBooked(int n, int[][] meetings) {
        
        int[] rooms = new int[n];
        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];
            for (int i = 0; i < n; i++) {
                if (rooms[i] <= start) {
                    rooms[i] = end;
                    break;
                }
            }
        }
        int max = 0;
        int index = -1;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int[] meeting : meetings) {
                if (meeting[0] >= rooms[i]) {
                    count++;
                }
            }
            if (count > max) {
                max = count;
                index = i;
            }
        }
        return index;
    }
}