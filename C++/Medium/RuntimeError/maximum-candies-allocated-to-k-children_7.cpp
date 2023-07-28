class Solution {
public:
    int maximumCandies(vector<int>& candies, long long k) {
        
        int n = candies.size();
        int ans = 0;
        auto cmp = [](const pair<int, int>& a, const pair<int, int>& b){
            return a.first < b.first;
        };
        priority_queue<pair<int, int>, vector<pair<int, int>>, decltype(cmp)> pq(cmp);
        for (int i = 0; i < n; i++) {
            pq.push({candies[i] / (n - i), i});
        }
        while (k > 0) {
            auto [v, i] = pq.top();
            pq.pop();
            ans += v;
            k -= n - i;
            if (k > 0) {
                pq.push({candies[i] / (n - i - 1), i + 1});
            }
        }
        return ans;
    }
};