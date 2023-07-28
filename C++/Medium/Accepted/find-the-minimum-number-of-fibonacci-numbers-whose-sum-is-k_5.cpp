class Solution {
public:
    int findMinFibonacciNumbers(int k) {
        
        int a = 1;
        int b = 1;
        vector<int> fib;
        fib.push_back(a);
        fib.push_back(b);
        while (true) {
            int c = a + b;
            if (c > k) {
                break;
            }
            fib.push_back(c);
            a = b;
            b = c;
        }
        int ans = 0;
        for (int i = fib.size() - 1; i >= 0; --i) {
            if (k >= fib[i]) {
                k -= fib[i];
                ++ans;
            }
            if (k == 0) {
                break;
            }
        }
        return ans;
    }
};