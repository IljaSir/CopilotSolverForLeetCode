class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        
        int n = arr.length;
        int m = pieces.length;
        int i = 0;
        int j = 0;
        while (i < n) {
            int k = 0;
            for (k = 0; k < m; k++) {
                if (pieces[k][0] == arr[i]) {
                    break;
                }
            }
            if (k == m) {
                return false;
            }
            for (j = 0; j < pieces[k].length; j++) {
                if (pieces[k][j] != arr[i]) {
                    return false;
                }
                i++;
            }
        }
        return true;
    }
}