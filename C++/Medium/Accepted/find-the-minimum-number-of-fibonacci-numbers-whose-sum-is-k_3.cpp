class Solution {
public:
    int findMinFibonacciNumbers(int k) {
        
        vector<int> fibo = {1, 1};
        while (fibo.back() < k) {
            fibo.push_back(fibo[fibo.size() - 1] + fibo[fibo.size() - 2]);
        }
        int ans = 0;
        for (int i = fibo.size() - 1; i >= 0; i--) {
            if (k >= fibo[i]) {
                k -= fibo[i];
                ans++;
            }
        }
        return ans;
    }
};