class Solution {
public:
    int findMinFibonacciNumbers(int k) {
        
        int a = 1;
        int b = 1;
        int c = 1;
        vector<int> fib;
        fib.push_back(a);
        fib.push_back(b);
        while (c < k) {
            c = a + b;
            fib.push_back(c);
            a = b;
            b = c;
        }
        int count = 0;
        for (int i = fib.size() - 1; i >= 0; i--) {
            if (k >= fib[i]) {
                k -= fib[i];
                count++;
            }
        }
        return count;
    }
};