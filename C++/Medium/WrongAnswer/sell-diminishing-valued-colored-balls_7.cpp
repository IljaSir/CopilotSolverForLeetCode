class Solution {
public:
    int maxProfit(vector<int>& inventory, int orders) {
        
        int n = inventory.size();
        sort(inventory.begin(), inventory.end());
        int i = n-1;
        while (i > 0 && inventory[i] == inventory[i-1]) i--;
        int j = i;
        int k = 0;
        while (i > 0 && orders > 0) {
            int a = inventory[i];
            int b = inventory[i-1];
            int c = a - b;
            int d = (i+1) * c;
            if (d <= orders) {
                k++;
                orders -= d;
                i--;
                while (i > 0 && inventory[i] == inventory[i-1]) i--;
                j = i;
            } else {
                break;
            }
        }
        int64_t ans = 0;
        int64_t m = inventory[i];
        int64_t r = orders / (i+1);
        int64_t s = orders % (i+1);
        int64_t t = m - r;
        int64_t u = m - r - 1;
        int64_t v = s * (t + 1);
        int64_t w = (i+1 - s) * (t * (t + 1) / 2);
        int64_t x = (i+1) * (i+2) / 2;
        int64_t y = k * (k+1) / 2;
        int64_t z = (i+1) * k;
        ans = (m * (m + 1) / 2 - (t + 1) * (t + 2) / 2) * (i+1);
        ans -= (m * (m + 1) / 2 - (u + 1) * (u + 2) / 2) * k;
        ans -= (v + w) * (i+1);
        ans += (x + y + z) * r;
        ans %= 1000000007;
        return ans;
    }
};