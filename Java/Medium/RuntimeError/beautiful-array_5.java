class Solution {
    public int[] beautifulArray(int n) {
        
        int[] result = new int[n];
        result[0] = 1;
        for (int i = 1; i < n; i *= 2) {
            int j = 0;
            for (int k = 0; k < i; k++) {
                result[i + j++] = result[k] * 2 - 1;
            }
            for (int k = 0; k < i; k++) {
                result[i + j++] = result[k] * 2;
            }
        }
        return result;
    }
}