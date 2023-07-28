class Solution {
    public int distinctIntegers(int n) {
        
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 1) {
                count++;
            }
        }
        return count;
    }
}