class Solution {
    public int[] getBiggestThree(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] sum = new int[m][n];
        for (int i = 0; i < m; i++){
            int s = 0;
            for (int j = 0; j < n; j++){
                s += grid[i][j];
                if (i == 0) sum[i][j] = s;
                else sum[i][j] = sum[i-1][j] + s;
            }
        }
        int[] ans = new int[3];
        int ansSize = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                int l = 0, r = Math.min(i, j);
                while (l <= r){
                    int mid = (l + r) / 2;
                    int s = getSum(sum, i, j, mid);
                    if (s == 0) l = mid + 1;
                    else if (s > 0) r = mid - 1;
                    else {
                        l = mid;
                        break;
                    }
                }
                int s = getSum(sum, i, j, l);
                if (s != 0){
                    int pos = ansSize;
                    while (pos > 0 && ans[pos-1] < s) pos--;
                    if (pos < 3){
                        for (int k = ansSize; k > pos; k--) ans[k] = ans[k-1];
                        ans[pos] = s;
                        if (ansSize < 3) ansSize++;
                    }
                }
            }
        }
        int[] ret = new int[ansSize];
        for (int i = 0; i < ansSize; i++) ret[i] = ans[i];
        return ret;
    }
}