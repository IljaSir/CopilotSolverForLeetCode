class Solution {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        
        int n = tiles.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            left[i] = tiles[i][0];
            right[i] = tiles[i][1];
        }
        Arrays.sort(left);
        Arrays.sort(right);
        int res = 0;
        int i = 0;
        int j = 0;
        int cur = 0;
        while (i < n) {
            if (left[i] <= right[j]) {
                cur++;
                i++;
            } else {
                cur--;
                j++;
            }
            if (cur > 0) {
                res = Math.max(res, cur * carpetLen + right[j] - left[i - 1]);
            }
        }
        return res;
    }
}