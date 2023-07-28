class Solution {
public:
    vector<int> closestPrimes(int left, int right) {
        
        vector<int> ans(2, -1);
        int minGap = right - left + 1;
        for (int i = left; i <= right; ++i) {
            if (isPrime(i)) {
                if (i - ans[0] < minGap) {
                    ans[1] = i;
                    minGap = ans[1] - ans[0];
                }
                ans[0] = i;
            }
        }
        return ans;
    }
};