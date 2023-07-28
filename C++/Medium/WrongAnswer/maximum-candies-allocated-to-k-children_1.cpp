class Solution {
public:
    int maximumCandies(vector<int>& candies, long long k) {
        
        sort(candies.begin(), candies.end());
        int n = candies.size();
        long long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += candies[i];
        }
        long long ans = 0;
        long long x = sum / k;
        for (int i = 0; i < n; i++) {
            if (candies[i] <= x) {
                ans += candies[i];
                k--;
            } else {
                break;
            }
        }
        ans += (k * x);
        return ans;
    }
};