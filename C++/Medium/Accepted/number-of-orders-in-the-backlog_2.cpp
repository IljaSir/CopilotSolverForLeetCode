class Solution {
public:
    int getNumberOfBacklogOrders(vector<vector<int>>& orders) {
        
        priority_queue<pair<int, int>> buy;
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> sell;
        for (auto& o : orders) {
            if (o[2] == 0) {
                // buy
                while (o[1] > 0 && !sell.empty() && sell.top().first <= o[0]) {
                    auto s = sell.top();
                    sell.pop();
                    if (s.second > o[1]) {
                        s.second -= o[1];
                        o[1] = 0;
                        sell.push(s);
                    } else {
                        o[1] -= s.second;
                    }
                }
                if (o[1] > 0) {
                    buy.push({o[0], o[1]});
                }
            } else {
                // sell
                while (o[1] > 0 && !buy.empty() && buy.top().first >= o[0]) {
                    auto b = buy.top();
                    buy.pop();
                    if (b.second > o[1]) {
                        b.second -= o[1];
                        o[1] = 0;
                        buy.push(b);
                    } else {
                        o[1] -= b.second;
                    }
                }
                if (o[1] > 0) {
                    sell.push({o[0], o[1]});
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
        return res % (1000000007);
    }
};