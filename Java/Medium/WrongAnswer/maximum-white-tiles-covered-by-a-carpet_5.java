class Solution {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        
        int n = tiles.length;
        int[][] events = new int[2 * n][2];
        for (int i = 0; i < n; i++) {
            events[2 * i][0] = tiles[i][0];
            events[2 * i][1] = 1;
            events[2 * i + 1][0] = tiles[i][1] - carpetLen + 1;
            events[2 * i + 1][1] = -1;
        }
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int res = 0, count = 0;
        for (int[] event : events) {
            count += event[1];
            res = Math.max(res, count);
        }
        return res;
    }
}