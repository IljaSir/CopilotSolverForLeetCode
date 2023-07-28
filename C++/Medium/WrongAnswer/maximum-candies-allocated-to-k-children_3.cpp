class Solution {
public:
    int maximumCandies(vector<int>& candies, long long k) {
        
        int n = candies.size();
        int l = 0, r = 1e7;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            long long sum = 0;
            for (int i = 0; i < n; i++) {
                sum += min(mid, candies[i]);
            }
            if (sum > k) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return l;
    }
};