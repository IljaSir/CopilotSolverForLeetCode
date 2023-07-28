class Solution {
public:
    int maxProfit(vector<int>& inventory, int orders) {
        
        sort(inventory.begin(), inventory.end(), greater<int>());
        long long int ans = 0;
        int i = 0;
        while(orders > 0) {
            if(i == inventory.size() - 1) {
                ans += inventory[i];
                i++;
                orders--;
                continue;
            }
            if(inventory[i] == inventory[i + 1]) {
                ans += inventory[i];
                i++;
                orders--;
                continue;
            }
            int diff = inventory[i] - inventory[i + 1];
            if(diff * (i + 1) <= orders) {
                ans += (long long int)(inventory[i] + inventory[i + 1] + 1) * diff / 2 * (i + 1);
                orders -= diff * (i + 1);
                i++;
            } else {
                int q = orders / (i + 1);
                int r = orders % (i + 1);
                ans += (long long int)(inventory[i] + inventory[i] - q + 1) * q / 2 * (i + 1);
                ans += (long long int)(inventory[i] - q) * r;
                orders = 0;
            }
        }
        return ans % (1000000007);
    }
};