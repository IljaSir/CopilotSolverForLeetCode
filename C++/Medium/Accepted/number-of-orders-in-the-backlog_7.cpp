class Solution {
public:
    int getNumberOfBacklogOrders(vector<vector<int>>& orders) {
        
        priority_queue<pair<int,int>> buy;
        priority_queue<pair<int,int>,vector<pair<int,int>>,greater<pair<int,int>>> sell;
        for (auto& order : orders) {
            int price = order[0];
            int amount = order[1];
            int orderType = order[2];
            if (orderType == 0) {
                while (amount > 0 && !sell.empty() && sell.top().first <= price) {
                    auto top = sell.top();
                    sell.pop();
                    if (top.second > amount) {
                        top.second -= amount;
                        amount = 0;
                        sell.push(top);
                    } else {
                        amount -= top.second;
                    }
                }
                if (amount > 0) {
                    buy.push({price, amount});
                }
            } else {
                while (amount > 0 && !buy.empty() && buy.top().first >= price) {
                    auto top = buy.top();
                    buy.pop();
                    if (top.second > amount) {
                        top.second -= amount;
                        amount = 0;
                        buy.push(top);
                    } else {
                        amount -= top.second;
                    }
                }
                if (amount > 0) {
                    sell.push({price, amount});
                }
            }
        }
        int ans = 0;
        while (!buy.empty()) {
            ans = (ans + buy.top().second) % 1000000007;
            buy.pop();
        }
        while (!sell.empty()) {
            ans = (ans + sell.top().second) % 1000000007;
            sell.pop();
        }
        return ans;
    }
};