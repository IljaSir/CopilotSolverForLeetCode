class Solution {
public:
    int getNumberOfBacklogOrders(vector<vector<int>>& orders) {
        
        const int MOD = 1e9+7;
        priority_queue<pair<int, int>> buy;
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> sell;
        for (auto& order: orders) {
            if (order[2] == 0) {
                int price = order[0], amount = order[1];
                while (!sell.empty() && sell.top().first <= price) {
                    if (sell.top().second > amount) {
                        sell.top().second -= amount;
                        amount = 0;
                        break;
                    } else {
                        amount -= sell.top().second;
                        sell.pop();
                    }
                }
                if (amount > 0) buy.push({price, amount});
            } else {
                int price = order[0], amount = order[1];
                while (!buy.empty() && buy.top().first >= price) {
                    if (buy.top().second > amount) {
                        buy.top().second -= amount;
                        amount = 0;
                        break;
                    } else {
                        amount -= buy.top().second;
                        buy.pop();
                    }
                }
                if (amount > 0) sell.push({price, amount});
            }
        }
        int ans = 0;
        while (!buy.empty()) {
            ans = (ans + buy.top().second) % MOD;
            buy.pop();
        }
        while (!sell.empty()) {
            ans = (ans + sell.top().second) % MOD;
            sell.pop();
        }
        return ans;
    }
};