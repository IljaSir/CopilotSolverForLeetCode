class Solution {
    public int[] sumZero(int n) {
        
        int[] result = new int[n];
        if (n % 2 == 1) {
            result[n / 2] = 0;
        }
        for (int i = 0; i < n / 2; i++) {
            result[i] = i + 1;
            result[n - 1 - i] = -result[i];
        }
        return result;
    }
}