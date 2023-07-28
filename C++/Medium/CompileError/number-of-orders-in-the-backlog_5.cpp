class Solution {
public:
    int getNumberOfBacklogOrders(vector<vector<int>>& orders) {
        
        priority_queue<pair<int,int>> buy;
        priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>> sell;
        for (auto& order: orders) {
            if (order[2] == 0) {
                while (!sell.empty() && sell.top().first <= order[0] && order[1] > 0) {
                    int a = min(order[1], sell.top().second);
                    order[1] -= a;
                    sell.top().second -= a;
                    if (sell.top().second == 0) {
                        sell.pop();
                    }
                }
                if (order[1] > 0) {
                    buy.push({order[0], order[1]});
                }
            } else {
                while (!buy.empty() && buy.top().first >= order[0] && order[1] > 0) {
                    int a = min(order[1], buy.top().second);
                    order[1] -= a;
                    buy.top().second -= a;
                    if (buy.top().second == 0) {
                        buy.pop();
                    }
                }
                if (order[1] > 0) {
                    sell.push({order[0], order[1]});
                }
            }
        }
        long long res = 0;
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