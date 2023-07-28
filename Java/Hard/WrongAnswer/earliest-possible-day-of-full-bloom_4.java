class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        
        int n = plantTime.length;
        int[][] flowers = new int[n][2];
        for (int i = 0; i < n; i++) {
            flowers[i][0] = plantTime[i];
            flowers[i][1] = growTime[i];
        }
        Arrays.sort(flowers, (a, b) -> a[0] - b[0]);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans + flowers[i][0], flowers[i][1]) + 1;
        }
        return ans;
    }
}