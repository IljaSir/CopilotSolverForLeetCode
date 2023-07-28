class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        
        int[] result = new int[queries.length];
        int[] prefixXOR = new int[arr.length];
        prefixXOR[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefixXOR[i] = prefixXOR[i - 1] ^ arr[i];
        }
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            result[i] = prefixXOR[query[1]] ^ (query[0] > 0 ? prefixXOR[query[0] - 1] : 0);
        }
        return result;
    }
}