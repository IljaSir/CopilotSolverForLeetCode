class Solution {
public:
    int maximumCandies(vector<int>& candies, long long k) {
        
        int n = candies.size();
        long long sum = accumulate(candies.begin(), candies.end(), 0LL);
        long long ans = 0;
        for (int i = 0; i < n; ++i) {
            long long cnt = min(k / n, (long long) candies[i]);
            ans += cnt;
            k -= cnt;
        }
        ans += k / n;
        return ans;
    }
};