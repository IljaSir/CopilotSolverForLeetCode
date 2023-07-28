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
        int i = 0, j = 0, res = 0, cur = 0;
        while (i < n) {
            if (starts[i] <= ends[j] + 1) {
                cur++;
                res = Math.max(res, cur);
                i++;
            } else {
                cur--;
                j++;
            }
        }
        return res + carpetLen - 1;
    }
}