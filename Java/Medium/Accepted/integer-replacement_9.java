class Solution {
    public int integerReplacement(int n) {
        
        int count = 0;
        long N = n;
        while (N != 1) {
            if (N % 2 == 0) {
                N /= 2;
            } else {
                if ((N + 1) % 4 == 0 && N != 3) {
                    N += 1;
                } else {
                    N -= 1;
                }
            }
            count++;
        }
        return count;
    }
}