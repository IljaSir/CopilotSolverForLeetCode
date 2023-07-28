class Solution {
public:
    vector<int> closestPrimes(int left, int right) {
        
        vector<int> ans(2, -1);
        for (int i = left; i <= right; i++) {
            if (isPrime(i)) {
                if (ans[0] == -1) {
                    ans[0] = i;
                } else if (ans[1] == -1) {
                    ans[1] = i;
                    break;
                } else if (i - ans[0] < ans[1] - ans[0]) {
                    ans[0] = i;
                } else {
                    ans[1] = i;
                    break;
                }
            }
        }
        return ans;
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