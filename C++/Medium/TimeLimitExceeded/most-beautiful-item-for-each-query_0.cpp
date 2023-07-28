class Solution {
public:
    vector<int> maximumBeauty(vector<vector<int>>& items, vector<int>& queries) {
        
        sort(items.begin(), items.end(), [](auto& a, auto& b) {
            return a[0] < b[0];
        });
        vector<int> res;
        for (auto& q : queries) {
            int maxBeauty = 0;
            for (auto& i : items) {
                if (i[0] <= q) {
                    maxBeauty = max(maxBeauty, i[1]);
                } else {
                    break;
                }
            }
            res.push_back(maxBeauty);
        }
        return res;
    }
};