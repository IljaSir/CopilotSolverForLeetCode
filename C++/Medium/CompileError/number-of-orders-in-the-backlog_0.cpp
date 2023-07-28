class Solution {
public:
    int getNumberOfBacklogOrders(vector<vector<int>>& orders) {
        
        priority_queue<pair<int, int>> buy;
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> sell;
        for (auto& order : orders) {
            if (order[2] == 0) {
                while (order[1] && !sell.empty() && sell.top().first <= order[0]) {
                    auto& p = sell.top();
                    if (p.second > order[1]) {
                        p.second -= order[1];
                        order[1] = 0;
                    } else {
                        order[1] -= p.second;
                        sell.pop();
                    }
                }
                if (order[1]) {
                    buy.push({order[0], order[1]});
                }
            } else {
                while (order[1] && !buy.empty() && buy.top().first >= order[0]) {
                    auto& p = buy.top();
                    if (p.second > order[1]) {
                        p.second -= order[1];
                        order[1] = 0;
                    } else {
                        order[1] -= p.second;
                        buy.pop();
                    }
                }
                if (order[1]) {
                    sell.push({order[0], order[1]});
                }
            }
        }
        int64_t res = 0;
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