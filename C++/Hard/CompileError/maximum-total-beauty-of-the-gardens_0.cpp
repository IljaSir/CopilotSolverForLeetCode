class Solution {
public:
    long long maximumBeauty(vector<int>& flowers, long long newFlowers, int target, int full, int partial) {
        
        int n = flowers.size();
        priority_queue<int> pq;
        long long sum = 0;
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            if (flowers[i] >= target) {
                ++cnt;
            } else {
                pq.push(target - flowers[i]);
            }
            sum += flowers[i];
        }
        long long ans = cnt * full + (pq.size() > 0 ? pq.top() * partial : 0);
        while (!pq.empty() && newFlowers > 0) {
            int top = pq.top();
            pq.pop();
            if (newFlowers >= top) {
                newFlowers -= top;
                ++cnt;
                sum += top;
                ans = max(ans, cnt * full + (pq.size() > 0 ? pq.top() * partial : 0));
            } else {
                sum += newFlowers;
                ans = max(ans, cnt * full + (sum + newFlowers) * partial);
                break;
            }
        }
        return ans;
    }
};