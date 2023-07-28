class Solution {
    public int smallestValue(int n) {
        
        int[] primeFactors = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            if (primeFactors[i] == 0) {
                for (int j = i; j <= n; j += i) {
                    primeFactors[j] += i;
                }
            }
        }
        while (n > primeFactors[n]) {
            n = primeFactors[n];
        }
        return n;
    }
}