class Solution {
public:
    int getNumberOfBacklogOrders(vector<vector<int>>& orders) {
        
        long long ans = 0;
        map<int, long long> sell, buy;
        for (auto& order : orders) {
            int price = order[0];
            long long amount = order[1];
            int orderType = order[2];
            if (orderType == 0) {
                // buy
                while (amount > 0 && !sell.empty() && sell.begin()->first <= price) {
                    auto it = sell.begin();
                    if (it->second <= amount) {
                        amount -= it->second;
                        sell.erase(it);
                    } else {
                        it->second -= amount;
                        amount = 0;
                    }
                }
                if (amount > 0) {
                    buy[price] += amount;
                }
            } else {
                // sell
                while (amount > 0 && !buy.empty() && buy.rbegin()->first >= price) {
                    auto it = buy.rbegin();
                    if (it->second <= amount) {
                        amount -= it->second;
                        buy.erase(--it.base());
                    } else {
                        it->second -= amount;
                        amount = 0;
                    }
                }
                if (amount > 0) {
                    sell[price] += amount;
                }
            }
        }
        for (auto& item : buy) {
            ans = (ans + item.second) % 1000000007;
        }
        for (auto& item : sell) {
            ans = (ans + item.second) % 1000000007;
        }
        return ans;
    }
};