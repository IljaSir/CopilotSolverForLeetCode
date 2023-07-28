class Solution {
public:
    int maxProfit(vector<int>& inventory, int orders) {
        
        int mod = 1000000007;
        long long sum = 0;
        sort(inventory.begin(), inventory.end(), greater<int>());
        int i = 0;
        while (orders > 0) {
            int cur = inventory[i];
            int next = i < inventory.size() - 1 ? inventory[i + 1] : 0;
            int cnt = next == cur ? 0 : orders / (i + 1);
            if (cnt > 0) {
                int step = cur - next;
                if (cnt > step) {
                    sum += (long long)(cur + next + 1) * step / 2 * (i + 1);
                    orders -= step * (i + 1);
                    cur = next;
                } else {
                    sum += (long long)(cur + cur - cnt + 1) * cnt / 2 * (i + 1);
                    orders -= cnt * (i + 1);
                    cur -= cnt;
                }
            } else {
                sum += (long long)cur * orders;
                orders = 0;
            }
            sum %= mod;
            i++;
        }
        return sum;
    }
};