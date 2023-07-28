class Solution {
public:
    int maxProfit(vector<int>& inventory, int orders) {
        
        int sum = 0;
        int mod = 1000000007;
        sort(inventory.begin(), inventory.end());
        for (int i = inventory.size() - 1; i >= 0; i--) {
            if (i == 0 || inventory[i] != inventory[i - 1]) {
                int n = inventory.size() - i;
                int diff = (inventory[i] - (i == 0 ? 0 : inventory[i - 1])) * n;
                if (orders <= diff) {
                    int q = orders / n;
                    int r = orders % n;
                    sum += (inventory[i] + inventory[i] - q + 1) * q / 2 * n;
                    sum += (inventory[i] - q) * r;
                    break;
                }
                sum += (inventory[i] + inventory[i] - diff / n + 1) * diff / 2;
                orders -= diff;
            }
        }
        return sum % mod;
    }
};