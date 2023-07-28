class Solution {
    public int[] beautifulArray(int n) {
        
        int[] res = new int[n];
        res[0] = 1;
        int size = 1;
        while (size < n) {
            int[] tmp = new int[n];
            int j = 0;
            for (int i = 0; i < size; i++) {
                if (2 * res[i] - 1 <= n) {
                    tmp[j++] = 2 * res[i] - 1;
                }
            }
            for (int i = 0; i < size; i++) {
                if (2 * res[i] <= n) {
                    tmp[j++] = 2 * res[i];
                }
            }
            res = tmp;
            size = j;
        }
        return res;
    }
}