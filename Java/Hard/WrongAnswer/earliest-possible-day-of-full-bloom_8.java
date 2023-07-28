class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        
        int n = plantTime.length;
        int[][] events = new int[n][2];
        for (int i = 0; i < n; i++) {
            events[i][0] = plantTime[i];
            events[i][1] = growTime[i];
        }
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans + events[i][0], events[i][1] + 1);
        }
        return ans;
    }
}