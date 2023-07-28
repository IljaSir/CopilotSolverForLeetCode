class Solution {
    public int[] sumZero(int n) {
        
        int[] result = new int[n];
        int i = 0;
        if (n % 2 == 1) {
            result[i++] = 0;
        }
        for (int j = 1; j <= n / 2; j++) {
            result[i++] = j;
            result[i++] = -j;
        }
        return result;
    }
}