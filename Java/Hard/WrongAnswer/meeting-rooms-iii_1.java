class Solution {
    public int mostBooked(int n, int[][] meetings) {
        
        int[] start = new int[meetings.length];
        int[] end = new int[meetings.length];
        for (int i = 0; i < meetings.length; i++) {
            start[i] = meetings[i][0];
            end[i] = meetings[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int i = 0, j = 0;
        int max = 0, count = 0;
        int room = 0;
        while (i < start.length && j < end.length) {
            if (start[i] < end[j]) {
                count++;
                if (count > max) {
                    max = count;
                    room = i;
                }
                i++;
            } else {
                count--;
                j++;
            }
        }
        return room;
    }
}