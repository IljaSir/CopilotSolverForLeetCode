class Solution {
    public int maximumGood(int[][] statements) {
        
        int n = statements.length;
        int[] good = new int[n];
        Arrays.fill(good, 1);
        boolean[] bad = new boolean[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (statements[i][j] == 0) {
                    bad[j] = true;
                } else if (statements[i][j] == 1) {
                    good[j] = 1;
                }
            }
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (!bad[j]) {
                    count += good[j];
                }
            }
            res = Math.max(res, count);
        }
        return res;
    }
}