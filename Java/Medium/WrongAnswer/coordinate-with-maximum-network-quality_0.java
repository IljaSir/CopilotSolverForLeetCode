class Solution {
    public int[] bestCoordinate(int[][] towers, int radius) {
        
        int max = 0;
        int[] ans = new int[2];
        for (int i = 0; i <= 50; i++) {
            for (int j = 0; j <= 50; j++) {
                int sum = 0;
                for (int[] t : towers) {
                    int d = (i - t[0]) * (i - t[0]) + (j - t[1]) * (j - t[1]);
                    if (d <= radius * radius) {
                        sum += t[2] / (1 + (int)Math.sqrt(d));
                    }
                }
                if (sum > max) {
                    max = sum;
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }
        return ans;
    }
}