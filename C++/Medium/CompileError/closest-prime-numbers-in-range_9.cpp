class Solution {
public:
    vector<int> closestPrimes(int left, int right) {
        
        int p = right;
        int q = left;
        while (p > 2) {
            if (isPrime(p)) break;
            p--;
        }
        while (q > 2) {
            if (isPrime(q)) break;
            q--;
        }
        if (p - q > 2) {
            return {q, p};
        }
        p = left;
        q = right;
        while (p < 1000001) {
            if (isPrime(p)) break;
            p++;
        }
        while (q < 1000001) {
            if (isPrime(q)) break;
            q++;
        }
        if (q - p > 2) {
            return {p, q};
        }
        return {-1, -1};
    }
};