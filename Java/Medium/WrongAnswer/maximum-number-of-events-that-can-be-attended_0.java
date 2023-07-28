class Solution {
    public int maxEvents(int[][] events) {
        
        int n = events.length;
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = events[i][0];
            end[i] = events[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int res = 0;
        int i = 0;
        int j = 0;
        while (i < n && j < n) {
            if (start[i] <= end[j]) {
                i++;
                res++;
            } else {
                j++;
            }
        }
        return res;
    }
}