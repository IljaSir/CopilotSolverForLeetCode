class Solution {
    public int maxNiceDivisors(int primeFactors) {
        
        if (primeFactors == 1) {
            return 1;
        }
        if (primeFactors == 2) {
            return 2;
        }
        if (primeFactors == 3) {
            return 3;
        }
        if (primeFactors % 3 == 0) {
            return (int)(Math.pow(3, primeFactors / 3) % (1e9 + 7));
        }
        if (primeFactors % 3 == 1) {
            return (int)(Math.pow(3, primeFactors / 3 - 1) * 4 % (1e9 + 7));
        }
        return (int)(Math.pow(3, primeFactors / 3) * 2 % (1e9 + 7));
    }
}