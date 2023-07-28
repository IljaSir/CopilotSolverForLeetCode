class Solution {
public:
    int getNumberOfBacklogOrders(vector<vector<int>>& orders) {
        
        map<int, int> buy, sell;
        for (auto& o: orders) {
            if (o[2] == 0) {
                // buy
                while (o[1] > 0 && sell.size() > 0 && sell.begin()->first <= o[0]) {
                    auto& [p, c] = *sell.begin();
                    int take = min(c, o[1]);
                    c -= take;
                    o[1] -= take;
                    if (c == 0) sell.erase(sell.begin());
                }
                if (o[1] > 0) buy[o[0]] += o[1];
            } else {
                // sell
                while (o[1] > 0 && buy.size() > 0 && buy.rbegin()->first >= o[0]) {
                    auto& [p, c] = *buy.rbegin();
                    int take = min(c, o[1]);
                    c -= take;
                    o[1] -= take;
                    if (c == 0) buy.erase(prev(buy.end()));
                }
                if (o[1] > 0) sell[o[0]] += o[1];
            }
        }
        long long ans = 0;
        for (auto& [p, c]: buy) {
            ans += c;
            ans %= 1000000007;
        }
        for (auto& [p, c]: sell) {
            ans += c;
            ans %= 1000000007;
        }
        return ans;
    }
};