class Solution {
public:
    int minimumLines(vector<vector<int>>& stockPrices) {
        
        vector<int> dp;
        for (auto& p : stockPrices) {
            int price = p[1];
            auto it = lower_bound(dp.begin(), dp.end(), price);
            if (it == dp.end()) dp.push_back(price);
            else *it = price;
        }
        return dp.size();
    }
};