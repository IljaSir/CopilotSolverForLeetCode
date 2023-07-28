class Solution {
public:
    int maximumCandies(vector<int>& candies, long long k) {
        
        int n = candies.size();
        int m = k / n;
        int r = k % n;
        int ans = 0;
        vector<int> a(n);
        for (int i = 0; i < n; i++) {
            a[i] = candies[i];
        }
        sort(a.begin(), a.end());
        for (int i = n - 1; i >= n - r; i--) {
            ans += a[i];
        }
        for (int i = 0; i < n; i++) {
            ans += a[i] * m;
        }
        return ans;
    }
};