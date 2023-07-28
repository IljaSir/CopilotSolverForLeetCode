class Solution {
public:
    int maximumCandies(vector<int>& candies, long long k) {
        
        int n = candies.size();
        int lo = 1, hi = 1e9;
        while (lo < hi) {
            int mid = (lo + hi + 1) >> 1;
            long long cnt = 0;
            for (int i = 0; i < n; ++i) {
                cnt += min((long long)mid, candies[i]);
            }
            if (cnt > k) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        long long ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += min((long long)lo, candies[i]);
        }
        return ans;
    }
};