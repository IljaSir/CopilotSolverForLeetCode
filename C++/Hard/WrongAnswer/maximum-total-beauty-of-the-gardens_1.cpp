class Solution {
public:
    long long maximumBeauty(vector<int>& flowers, long long newFlowers, int target, int full, int partial) {
        
        long long ans = 0;
        priority_queue<int, vector<int>, greater<int>> pq;
        int n = flowers.size();
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            if (flowers[i] >= target) {
                ++cnt;
            } else {
                pq.push(flowers[i]);
            }
        }
        ans = (long long)cnt * full;
        while (!pq.empty()) {
            int t = pq.top();
            pq.pop();
            if (newFlowers >= target - t) {
                newFlowers -= target - t;
                ++cnt;
                ans = max(ans, (long long)cnt * full + (long long)pq.size() * partial);
            } else {
                break;
            }
        }
        ans = max(ans, (long long)cnt * full + (long long)pq.size() * partial + newFlowers * partial);
        return ans;
    }
};