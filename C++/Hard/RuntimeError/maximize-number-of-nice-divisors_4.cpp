class Solution {
public:
    int maxNiceDivisors(int primeFactors) {
        
        if (primeFactors == 1) return 1;
        if (primeFactors == 2) return 2;
        if (primeFactors == 3) return 3;
        int a = primeFactors / 3;
        int b = primeFactors % 3;
        if (b == 0) return pow(3, a);
        if (b == 1) return 4 * pow(3, a - 1);
        return 2 * pow(3, a);
    }
};