class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        
        int[] prefixXOR = new int[arr.length];
        prefixXOR[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefixXOR[i] = prefixXOR[i - 1] ^ arr[i];
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            if (left == 0) {
                result[i] = prefixXOR[right];
            } else {
                result[i] = prefixXOR[left - 1] ^ prefixXOR[right];
            }
        }
        return result;
    }
}