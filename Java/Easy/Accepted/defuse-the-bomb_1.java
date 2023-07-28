class Solution {
    public int[] decrypt(int[] code, int k) {
        
        int[] result = new int[code.length];
        if (k == 0) {
            return result;
        }
        if (k > 0) {
            for (int i = 0; i < code.length; i++) {
                int sum = 0;
                for (int j = 1; j <= k; j++) {
                    sum += code[(i + j) % code.length];
                }
                result[i] = sum;
            }
        } else {
            for (int i = 0; i < code.length; i++) {
                int sum = 0;
                for (int j = 1; j <= -k; j++) {
                    sum += code[(i - j + code.length) % code.length];
                }
                result[i] = sum;
            }
        }
        return result;
    }
}