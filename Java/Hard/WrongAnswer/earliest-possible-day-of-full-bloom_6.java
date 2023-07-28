class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        
        int n = plantTime.length;
        int[][] seeds = new int[n][2];
        for (int i = 0; i < n; i++) {
            seeds[i][0] = plantTime[i];
            seeds[i][1] = growTime[i];
        }
        Arrays.sort(seeds, (a, b) -> a[0] - b[0]);
        int[] bloom = new int[n];
        bloom[0] = seeds[0][0] + seeds[0][1];
        for (int i = 1; i < n; i++) {
            bloom[i] = Math.max(bloom[i - 1], seeds[i][0]) + seeds[i][1];
        }
        return bloom[n - 1];
    }
}