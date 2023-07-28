class Solution {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        
        int[] count = new int[1000000001];
        for (int[] tile : tiles) {
            count[tile[0]]++;
            count[tile[1] + 1]--;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        int max = 0;
        for (int i = 1; i < count.length; i++) {
            max = Math.max(max, count[i]);
        }
        return max;
    }
}