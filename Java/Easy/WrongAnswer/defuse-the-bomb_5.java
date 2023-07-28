class Solution {
    public int[] decrypt(int[] code, int k) {
        
        int n = code.length;
        int[] res = new int[n];
        if (k == 0) {
            return res;
        }
        int sum = 0;
        for (int i = 1; i <= Math.abs(k); i++) {
            sum += code[(i + n) % n];
        }
        for (int i = 0; i < n; i++) {
            res[i] = sum;
            sum -= code[(i + 1 + n) % n];
            sum += code[(i + 1 + k + n) % n];
        }
        return res;
    }
}