class Solution {
    public int[] decrypt(int[] code, int k) {
        
        int n = code.length;
        int[] result = new int[n];
        if (k == 0) {
            return result;
        }
        for (int i = 0; i < n; i++) {
            int start = k > 0 ? i + 1 : i - 1;
            int end = k > 0 ? i + k : i + k + 1;
            int sum = 0;
            for (int j = start; j != end; j = k > 0 ? j + 1 : j - 1) {
                sum += code[(j + n) % n];
            }
            result[i] = sum;
        }
        return result;
    }
}