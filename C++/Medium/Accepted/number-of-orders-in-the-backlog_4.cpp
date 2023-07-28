class Solution {
public:
    int getNumberOfBacklogOrders(vector<vector<int>>& orders) {
        
        priority_queue<pair<int, int>> buy; // price, amount
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> sell; // price, amount
        for (auto& order : orders) {
            if (order[2] == 0) {
                while (order[1] && !sell.empty() && sell.top().first <= order[0]) {
                    auto top = sell.top();
                    sell.pop();
                    if (top.second > order[1]) {
                        top.second -= order[1];
                        sell.push(top);
                        order[1] = 0;
                    } else {
                        order[1] -= top.second;
                    }
                }
                if (order[1]) {
                    buy.push({order[0], order[1]});
                }
            } else {
                while (order[1] && !buy.empty() && buy.top().first >= order[0]) {
                    auto top = buy.top();
                    buy.pop();
                    if (top.second > order[1]) {
                        top.second -= order[1];
                        buy.push(top);
                        order[1] = 0;
                    } else {
                        order[1] -= top.second;
                    }
                }
                if (order[1]) {
                    sell.push({order[0], order[1]});
                }
            }
        }
        int res = 0;
        while (!buy.empty()) {
            res = (res + buy.top().second) % 1000000007;
            buy.pop();
        }
        while (!sell.empty()) {
            res = (res + sell.top().second) % 1000000007;
            sell.pop();
        }
        return res;
    }
};