class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        
        int n = arr.length;
        int[] xors = new int[n];
        xors[0] = arr[0];
        for (int i = 1; i < n; i++) {
            xors[i] = xors[i - 1] ^ arr[i];
        }
        int m = queries.length;
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            int[] q = queries[i];
            int left = q[0];
            int right = q[1];
            if (left == 0) {
                res[i] = xors[right];
            } else {
                res[i] = xors[left - 1] ^ xors[right];
            }
        }
        return res;
    }
}