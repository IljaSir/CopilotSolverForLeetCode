class Solution {
public:
    int maxProfit(vector<int>& inventory, int orders) {
        
        int mod = 1e9 + 7;
        priority_queue<int> pq(inventory.begin(), inventory.end());
        long long ans = 0;
        while (orders > 0) {
            int cur = pq.top();
            pq.pop();
            ans += cur;
            if (pq.empty() || cur - 1 <= pq.top()) {
                int cnt = min(orders, cur - (pq.empty() ? 0 : pq.top()));
                ans -= 1ll * cnt * (cnt + 1) / 2;
                ans %= mod;
                orders -= cnt;
                if (orders > 0) {
                    pq.push(cur - cnt);
                }
            } else {
                pq.push(cur - 1);
            }
        }
        return ans;
    }
};