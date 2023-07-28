class Solution {
public:
    vector<int> closestPrimes(int left, int right) {
        
        int i = left;
        int j = right;
        while (i >= 2) {
            if (isPrime(i)) {
                break;
            }
            --i;
        }
        while (j <= 1000000) {
            if (isPrime(j)) {
                break;
            }
            ++j;
        }
        if (i >= 2 && j <= 1000000) {
            return {i, j};
        }
        return {-1, -1};
    }
};