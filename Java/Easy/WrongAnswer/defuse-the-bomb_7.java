class Solution {
    public int[] decrypt(int[] code, int k) {
        
        int n = code.length;
        int[] result = new int[n];
        if (k == 0) {
            return result;
        }
        int sum = 0;
        if (k > 0) {
            for (int i = 0; i < k; i++) {
                sum += code[i];
            }
            for (int i = 0; i < n; i++) {
                result[i] = sum;
                sum -= code[i];
                sum += code[(i + k) % n];
            }
        } else {
            for (int i = n - 1; i >= n + k; i--) {
                sum += code[i];
            }
            for (int i = n - 1; i >= 0; i--) {
                result[i] = sum;
                sum -= code[(i + k + 1) % n];
                sum += code[i];
            }
        }
        return result;
    }
}