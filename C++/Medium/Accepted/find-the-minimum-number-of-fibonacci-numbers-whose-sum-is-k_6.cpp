class Solution {
public:
    int findMinFibonacciNumbers(int k) {
        
        int a = 1, b = 1;
        vector<int> f;
        f.push_back(a);
        f.push_back(b);
        while (b <= k) {
            int c = a + b;
            a = b;
            b = c;
            f.push_back(b);
        }
        int ans = 0;
        for (int i = f.size() - 1; i >= 0; i--) {
            if (f[i] <= k) {
                k -= f[i];
                ans++;
            }
        }
        return ans;
    }
};