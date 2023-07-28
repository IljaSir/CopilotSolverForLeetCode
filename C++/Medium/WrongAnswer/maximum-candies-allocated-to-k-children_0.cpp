class Solution {
public:
    int maximumCandies(vector<int>& candies, long long k) {
        
        long long lo = 0, hi = *max_element(candies.begin(), candies.end());
        while (lo < hi) {
            long long mid = lo + (hi - lo + 1) / 2;
            long long cnt = 0;
            for (auto c : candies) {
                cnt += (c + mid - 1) / mid;
            }
            if (cnt <= k) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }
};