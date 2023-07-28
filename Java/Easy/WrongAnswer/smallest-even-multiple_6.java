class Solution {
    public int smallestEvenMultiple(int n) {
        
        int i = 1;
        while (i <= n) {
            if (n % i == 0) {
                if (i % 2 == 0) {
                    return i;
                }
            }
            i++;
        }
        return 0;
    }
}