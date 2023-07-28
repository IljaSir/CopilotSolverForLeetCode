class Solution {
public:
    int findMinFibonacciNumbers(int k) {
        
        vector<int> fibs;
        fibs.push_back(1);
        fibs.push_back(1);
        while (fibs.back() <= k) {
            fibs.push_back(fibs.back() + fibs[fibs.size() - 2]);
        }
        int ans = 0;
        for (int i = fibs.size() - 1; i >= 0; i--) {
            if (fibs[i] <= k) {
                k -= fibs[i];
                ans++;
            }
        }
        return ans;
    }
};