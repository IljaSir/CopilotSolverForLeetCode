class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int xor = 0;
            for (int j = query[0]; j <= query[1]; j++) {
                xor ^= arr[j];
            }
            ans[i] = xor;
        }
        return ans;
    }
}