class Solution {
public:
    int findMinFibonacciNumbers(int k) {
        
        vector<int> fib{1, 1};
        while (fib.back() < k) {
            fib.push_back(fib[fib.size() - 1] + fib[fib.size() - 2]);
        }
        int res = 0;
        for (int i = fib.size() - 1; i >= 0; i--) {
            if (k >= fib[i]) {
                k -= fib[i];
                res++;
            }
        }
        return res;
    }
};