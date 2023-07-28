class Solution {
public:
    int maxProfit(vector<int>& inventory, int orders) {
        
        sort(inventory.begin(), inventory.end());
        int n = inventory.size();
        int mod = 1e9 + 7;
        long long res = 0;
        int i = n - 1;
        while (orders > 0) {
            int cur = inventory[i];
            int next = (i == 0) ? 0 : inventory[i - 1];
            int cnt = min(orders, (long long)(cur - next) * (n - i));
            int a = cur;
            int b = cur - cnt / (n - i);
            int c = cnt % (n - i);
            res += (long long)(a + b + 1) * c / 2;
            res += (long long)(a + b + 1) * (a - b) / 2 * (n - i - c);
            res %= mod;
            orders -= cnt;
            i--;
        }
        return res;
    }
};