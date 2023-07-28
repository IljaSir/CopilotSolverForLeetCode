class Solution {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        
        int n = tiles.length;
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = tiles[i][0];
            end[i] = tiles[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int i = 0, j = 0;
        int res = 0;
        int count = 0;
        while (i < n && j < n) {
            if (start[i] < end[j]) {
                count++;
                res = Math.max(res, count);
                i++;
            } else {
                count--;
                j++;
            }
        }
        return res + carpetLen - 1;
    }
}