class Solution {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        
        int n = tiles.length;
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = tiles[i][0];
            ends[i] = tiles[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int ans = 0;
        int j = 0;
        int cur = 0;
        for (int i = 0; i < n; i++) {
            while (j < n && ends[j] < starts[i] + carpetLen) {
                cur++;
                j++;
            }
            ans = Math.max(ans, cur);
            cur--;
        }
        return ans;
    }
}