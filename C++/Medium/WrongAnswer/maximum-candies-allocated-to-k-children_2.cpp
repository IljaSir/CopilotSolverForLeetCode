class Solution {
public:
    int maximumCandies(vector<int>& candies, long long k) {
        
        int n = candies.size();
        long long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += candies[i];
        }
        long long l = 0, r = sum;
        while (l < r) {
            long long mid = l + (r - l) / 2;
            if (check(candies, mid, k)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l - 1;
    }
    bool check(vector<int>& candies, long long mid, long long k) {
        int n = candies.size();
        long long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += min((long long)candies[i], mid);
        }
        return sum <= k;
    }
};