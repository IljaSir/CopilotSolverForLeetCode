class Solution {
    public int[] decrypt(int[] code, int k) {
        
        int n = code.length;
        int[] result = new int[n];
        if (k == 0) {
            return result;
        }
        int sum = 0;
        if (k > 0) {
            for (int i = 1; i <= k; i++) {
                sum += code[i];
            }
            for (int i = 0; i < n; i++) {
                result[i] = sum;
                sum -= code[(i + 1) % n];
                sum += code[(i + k + 1) % n];
            }
        } else {
            for (int i = 1; i <= -k; i++) {
                sum += code[(n - i) % n];
            }
            for (int i = 0; i < n; i++) {
                result[i] = sum;
                sum -= code[(n + i - 1) % n];
                sum += code[(n + i + k - 1) % n];
            }
        }
        return result;
    }
}