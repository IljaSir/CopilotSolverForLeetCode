class Solution {
public:
    int getNumberOfBacklogOrders(vector<vector<int>>& orders) {
        
        priority_queue<pair<int, int>> buy;
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> sell;
        for (auto& order : orders) {
            int price = order[0], amount = order[1], orderType = order[2];
            if (orderType == 0) {
                // buy
                while (amount > 0 && !sell.empty() && sell.top().first <= price) {
                    auto& top = sell.top();
                    if (top.second <= amount) {
                        amount -= top.second;
                        sell.pop();
                    } else {
                        top.second -= amount;
                        amount = 0;
                    }
                }
                if (amount > 0) {
                    buy.push({price, amount});
                }
            } else {
                // sell
                while (amount > 0 && !buy.empty() && buy.top().first >= price) {
                    auto& top = buy.top();
                    if (top.second <= amount) {
                        amount -= top.second;
                        buy.pop();
                    } else {
                        top.second -= amount;
                        amount = 0;
                    }
                }
                if (amount > 0) {
                    sell.push({price, amount});
                }
            }
        }
        int res = 0;
        while (!buy.empty()) {
            res += buy.top().second;
            buy.pop();
        }
        while (!sell.empty()) {
            res += sell.top().second;
            sell.pop();
        }
        return res % 1000000007;
    }
};