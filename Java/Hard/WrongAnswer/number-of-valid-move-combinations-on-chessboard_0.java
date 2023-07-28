class Solution {
    public int countCombinations(String[] pieces, int[][] positions) {
        
        int n = positions.length;
        int[] xs = new int[n];
        int[] ys = new int[n];
        for (int i = 0; i < n; i++) {
            xs[i] = positions[i][0];
            ys[i] = positions[i][1];
        }
        return dfs(pieces, xs, ys, 0);
    }
    private int dfs(String[] pieces, int[] xs, int[] ys, int i) {
        if (i == pieces.length) {
            return 1;
        }
        int sum = 0;
        for (int j = 1; j <= 8; j++) {
            for (int k = 1; k <= 8; k++) {
                if (valid(pieces[i], xs, ys, i, j, k)) {
                    xs[i] = j;
                    ys[i] = k;
                    sum += dfs(pieces, xs, ys, i + 1);
                    xs[i] = 0;
                    ys[i] = 0;
                }
            }
        }
        return sum;
    }
    private boolean valid(String piece, int[] xs, int[] ys, int i, int x, int y) {
        if (piece.equals("rook")) {
            for (int j = 0; j < i; j++) {
                if (xs[j] == x || ys[j] == y) {
                    return false;
                }
            }
        } else if (piece.equals("queen")) {
            for (int j = 0; j < i; j++) {
                if (xs[j] == x || ys[j] == y || Math.abs(xs[j] - x) == Math.abs(ys[j] - y)) {
                    return false;
                }
            }
        } else {
            for (int j = 0; j < i; j++) {
                if (Math.abs(xs[j] - x) == Math.abs(ys[j] - y)) {
                    return false;
                }
            }
        }
        return true;
    }
}