class Solution {
    public int[] decrypt(int[] code, int k) {
        
        int n = code.length;
        int[] res = new int[n];
        if (k == 0) {
            return res;
        }
        int sum = 0;
        if (k > 0) {
            for (int i = 1; i <= k; i++) {
                sum += code[i];
            }
            for (int i = 0; i < n; i++) {
                res[i] = sum;
                sum -= code[(i + 1) % n];
                sum += code[(i + k + 1) % n];
            }
        } else {
            for (int i = n - 1; i > n - 1 + k; i--) {
                sum += code[(i + n) % n];
            }
            for (int i = 0; i < n; i++) {
                res[i] = sum;
                sum -= code[(i - 1 + n) % n];
                sum += code[(i + k - 1 + n) % n];
            }
        }
        return res;
    }
}