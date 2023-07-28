class Solution {
public:
    int maximumCandies(vector<int>& candies, long long k) {
        
        int ans = 0;
        int n = candies.size();
        for (int i = 0; i < n; ++i) {
            long long t = (sqrt(1 + 8 * candies[i]) - 1) / 2;
            ans += min(t, k);
            k -= t;
            if (k <= 0) break;
        }
        return ans;
    }
};