class Solution {
public:
    int maxProfit(vector<int>& inventory, int orders) {
        
        sort(inventory.begin(), inventory.end());
        int n = inventory.size();
        long long ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (i == 0) {
                ans += (long long)inventory[i] * orders;
                orders = 0;
            } else {
                long long diff = inventory[i] - inventory[i - 1];
                if (diff * (n - i) <= orders) {
                    ans += (long long)(inventory[i] + inventory[i - 1] + 1) * diff * (n - i) / 2;
                    orders -= diff * (n - i);
                } else {
                    long long k = orders / (n - i);
                    ans += (long long)(inventory[i] + inventory[i] - k + 1) * k * (n - i) / 2;
                    orders -= k * (n - i);
                    ans += (long long)k * orders;
                    orders = 0;
                }
            }
        }
        return ans % 1000000007;
    }
};