class Solution {
    public int countCombinations(String[] pieces, int[][] positions) {
        
        int n = pieces.length;
        int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int[] pieceTypes = new int[n];
        for (int i = 0; i < n; i++) {
            pieceTypes[i] = pieces[i].equals("rook") ? 0 : pieces[i].equals("queen") ? 1 : 2;
        }
        int[] dx = new int[n];
        int[] dy = new int[n];
        int[] max = new int[n];
        int[] min = new int[n];
        int[] max2 = new int[n];
        int[] min2 = new int[n];
        int[] max3 = new int[n];
        int[] min3 = new int[n];
        for (int i = 0; i < n; i++) {
            dx[i] = positions[i][0];
            dy[i] = positions[i][1];
            max[i] = 8 - dx[i];
            min[i] = dx[i] - 1;
            max2[i] = 8 - dy[i];
            min2[i] = dy[i] - 1;
            max3[i] = Math.min(max[i], max2[i]);
            min3[i] = Math.min(min[i], min2[i]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int x = dx[i];
            int y = dy[i];
            int type = pieceTypes[i];
            int max1 = max[i];
            int min1 = min[i];
            int max21 = max2[i];
            int min21 = min2[i];
            int max31 = max3[i];
            int min31 = min3[i];
            if (type == 0 || type == 1) {
                res += max1 + min1 + max21 + min21;
            }
            if (type == 2 || type == 1) {
                res += max31 + min31;
            }
            for (int j = i + 1; j < n; j++) {
                int x2 = dx[j];
                int y2 =
    }
}