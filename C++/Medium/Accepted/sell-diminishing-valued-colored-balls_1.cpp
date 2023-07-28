class Solution {
public:
    int maxProfit(vector<int>& inventory, int orders) {
        
        int MOD = 1e9 + 7;
        long long ans = 0;
        sort(inventory.begin(), inventory.end());
        for (int i = inventory.size() - 1; i >= 0; --i) {
            int cur = inventory[i];
            int next = i > 0 ? inventory[i - 1] : 0;
            int diff = cur - next;
            if (orders <= diff * (inventory.size() - i)) {
                int q = orders / (inventory.size() - i);
                int r = orders % (inventory.size() - i);
                ans = (ans + (long long)q * (cur + cur - q + 1) / 2 * (inventory.size() - i) + (long long)r * (cur - q)) % MOD;
                break;
            } else {
                ans = (ans + (long long)diff * (cur + cur - diff + 1) / 2 * (inventory.size() - i)) % MOD;
                orders -= diff * (inventory.size() - i);
            }
        }
        return ans;
    }
};