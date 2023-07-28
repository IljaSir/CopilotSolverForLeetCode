class Solution {
    public int distinctIntegers(int n) {
        
        int result = 0;
        for (int i = 1; i <= n; i++) {
            int j = 1;
            while (j <= n) {
                j = j * 10;
            }
            result += j / 10;
        }
        return result;
    }
}