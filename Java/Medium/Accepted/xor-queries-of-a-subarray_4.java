class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        
        int[] xor = new int[arr.length];
        xor[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            xor[i] = xor[i-1] ^ arr[i];
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            if (query[0] == 0) {
                ans[i] = xor[query[1]];
            } else {
                ans[i] = xor[query[1]] ^ xor[query[0] - 1];
            }
        }
        return ans;
    }
}