class Solution {
    public String kthSmallestPath(int[] destination, int k) {
        
        int row = destination[0], col = destination[1];
        char[] res = new char[row + col];
        int index = 0;
        while (row > 0 || col > 0) {
            if (row == 0) {
                res[index++] = 'H';
                col--;
            } else if (col == 0) {
                res[index++] = 'V';
                row--;
            } else {
                int r = row - 1, c = col;
                int cnt = 0;
                while (r >= 0 && c >= 0) {
                    cnt += C(r + c, r);
                    r--;
                }
                if (cnt >= k) {
                    res[index++] = 'V';
                    row--;
                } else {
                    res[index++] = 'H';
                    col--;
                    k -= cnt;
                }
            }
        }
        return new String(res);
    }

    private int C(int n, int r) {
        long res = 1;
        for (int i = 1; i <= r; i++) {
            res = res * (n - i + 1) / i;
        }
        return (int)res;
    }
}