class Solution {
    public int[] processQueries(int[] queries, int m) {
        
        int[] result = new int[queries.length];
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = i + 1;
        }
        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == queries[i]) {
                    result[i] = j;
                    int temp = arr[j];
                    for (int k = j; k > 0; k--) {
                        arr[k] = arr[k - 1];
                    }
                    arr[0] = temp;
                    break;
                }
            }
        }
        return result;
    }
}