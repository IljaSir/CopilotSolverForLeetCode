class Solution {
public:
    int getNumberOfBacklogOrders(vector<vector<int>>& orders) {
        
        priority_queue<pair<int, int>> buy;
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> sell;
        for (auto &order : orders) {
            int price = order[0];
            int amount = order[1];
            int type = order[2];
            if (type == 0) {
                while (amount > 0 && !sell.empty() && sell.top().first <= price) {
                    auto s = sell.top();
                    sell.pop();
                    int sAmount = s.second;
                    if (sAmount >= amount) {
                        sAmount -= amount;
                        amount = 0;
                        if (sAmount > 0) {
                            sell.push({s.first, sAmount});
                        }
                    } else {
                        amount -= sAmount;
                    }
                }
                if (amount > 0) {
                    buy.push({price, amount});
                }
            } else {
                while (amount > 0 && !buy.empty() && buy.top().first >= price) {
                    auto b = buy.top();
                    buy.pop();
                    int bAmount = b.second;
                    if (bAmount >= amount) {
                        bAmount -= amount;
                        amount = 0;
                        if (bAmount > 0) {
                            buy.push({b.first, bAmount});
                        }
                    } else {
                        amount -= bAmount;
                    }
                }
                if (amount > 0) {
                    sell.push({price, amount});
                }
            }
        }
        int ans = 0;
        while (!buy.empty()) {
            ans += buy.top().second;
            ans %= 1000000007;
            buy.pop();
        }
        while (!sell.empty()) {
            ans += sell.top().second;
            ans %= 1000000007;
            sell.pop();
        }
        return ans;
    }
};