class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] ^ arr[i];
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int left = query[0];
            int right = query[1];
            if (left == right) {
                result[i] = arr[left];
            } else if (left == 0) {
                result[i] = prefix[right];
            } else {
                result[i] = prefix[left - 1] ^ prefix[right];
            }
        }
        return result;
    }
}