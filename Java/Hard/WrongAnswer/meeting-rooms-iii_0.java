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
        int max = 0;
        int temp = 0;
        int i = 0, j = 0;
        while (i < start.length && j < end.length) {
            if (start[i] < end[j]) {
                temp++;
                i++;
            } else {
                temp--;
                j++;
            }
            max = Math.max(max, temp);
        }
        return max;
    }
}