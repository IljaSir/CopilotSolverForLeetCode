class Solution {
public:
    int maximumCandies(vector<int>& candies, long long k) {
        
        long long l = 0, r = 1e12, m, ans = 0;
        while (l <= r) {
            m = l + (r - l) / 2;
            long long sum = 0;
            for (auto &c : candies) {
                sum += min(m, (long long)c);
            }
            if (sum <= k) {
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ans;
    }
};