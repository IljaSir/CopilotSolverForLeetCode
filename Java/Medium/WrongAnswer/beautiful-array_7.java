class Solution {
    public int[] beautifulArray(int n) {
        
        int[] result = new int[n];
        result[0] = 1;
        for (int m = 1; m < n; m <<= 1) {
            for (int i = 0, j = m; j < n; ++i, ++j) {
                result[j] = result[i] + m;
            }
        }
        return result;
    }
}