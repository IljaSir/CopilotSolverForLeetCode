class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        
        int[] prefixXor = new int[arr.length];
        prefixXor[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefixXor[i] = prefixXor[i - 1] ^ arr[i];
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int left = query[0];
            int right = query[1];
            if (left == 0) {
                result[i] = prefixXor[right];
            } else {
                result[i] = prefixXor[left - 1] ^ prefixXor[right];
            }
        }
        return result;
    }
}