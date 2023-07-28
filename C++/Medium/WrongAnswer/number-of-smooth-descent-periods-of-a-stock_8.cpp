class Solution {
public:
    long long getDescentPeriods(vector<int>& prices) {
        
        long long n = prices.size();
        long long ans = 0;
        for(long long i = 0; i < n; i++) {
            long long j = i;
            while(j < n - 1 && prices[j] - prices[j + 1] == 1) {
                j++;
            }
            ans += (j - i + 1) * (j - i) / 2;
            i = j;
        }
        return ans;
    }
};