class Solution {
    public int integerReplacement(int n) {
        
        int count = 0;
        while (n > 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                if (n == 3 || (n + 1) % 4 == 0) {
                    n = n - 1;
                } else {
                    n = n + 1;
                }
            }
            count++;
        }
        return count;
    }
}