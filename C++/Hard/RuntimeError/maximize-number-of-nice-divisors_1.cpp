class Solution {
public:
    int maxNiceDivisors(int primeFactors) {
        
        if (primeFactors == 1) return 1;
        if (primeFactors == 2) return 2;
        if (primeFactors == 3) return 3;
        if (primeFactors % 3 == 0) return pow(3, primeFactors / 3);
        if (primeFactors % 3 == 1) return 4 * pow(3, (primeFactors - 4) / 3);
        return 2 * pow(3, primeFactors / 3);
    }
};