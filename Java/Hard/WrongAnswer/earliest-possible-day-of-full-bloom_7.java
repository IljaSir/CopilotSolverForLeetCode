class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        
        int n = plantTime.length;
        int[][] flowers = new int[n][2];
        for(int i = 0; i < n; i++) {
            flowers[i][0] = plantTime[i];
            flowers[i][1] = plantTime[i] + growTime[i];
        }
        Arrays.sort(flowers, (a, b) -> a[0] - b[0]);
        int max = 0;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, flowers[i][0]);
            max += flowers[i][1];
        }
        return max;
    }
}