class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        
        int[] xor = new int[arr.length];
        xor[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            xor[i] = xor[i - 1] ^ arr[i];
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            if (left == 0) {
                res[i] = xor[right];
            } else {
                res[i] = xor[left - 1] ^ xor[right];
            }
        }
        return res;
    }
}