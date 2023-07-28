class Solution {
    public int[] beautifulArray(int n) {
        
        int[] result = new int[n];
        result[0] = 1;
        int i = 1;
        while (i < n) {
            int j = 0;
            for (int k = 0; k < i; k++) {
                if (result[k] * 2 - 1 <= n) {
                    result[j++] = result[k] * 2 - 1;
                }
            }
            for (int k = 0; k < i; k++) {
                if (result[k] * 2 <= n) {
                    result[j++] = result[k] * 2;
                }
            }
            i *= 2;
        }
        return result;
    }
}