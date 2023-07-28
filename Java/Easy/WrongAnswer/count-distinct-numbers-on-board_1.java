class Solution {
    public int distinctIntegers(int n) {
        
        int[] count = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int j = 1;
            while (i * j <= n) {
                count[i * j]++;
                j++;
            }
        }
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (count[i] == 1) {
                result++;
            }
        }
        return result;
    }
}