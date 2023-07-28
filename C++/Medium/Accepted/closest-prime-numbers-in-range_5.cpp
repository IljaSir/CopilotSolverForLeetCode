class Solution {
public:
    vector<int> closestPrimes(int left, int right) {
        
        vector<int> result;
        int min_gap = INT_MAX;
        for (int i = left; i <= right; i++) {
            if (isPrime(i)) {
                for (int j = i + 1; j <= right; j++) {
                    if (isPrime(j)) {
                        int gap = j - i;
                        if (gap < min_gap) {
                            result.clear();
                            result.push_back(i);
                            result.push_back(j);
                            min_gap = gap;
                        }
                        break;
                    }
                }
            }
        }
        if (result.empty()) {
            result.push_back(-1);
            result.push_back(-1);
        }
        return result;
    }
    
    bool isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
};