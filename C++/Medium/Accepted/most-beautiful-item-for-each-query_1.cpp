class Solution {
public:
    vector<int> maximumBeauty(vector<vector<int>>& items, vector<int>& queries) {
        
        sort(items.begin(), items.end(), [](const vector<int>& a, const vector<int>& b){return a[0] < b[0];});
        int maxBeauty = 0;
        for (int i = 0; i < items.size(); i++) {
            maxBeauty = max(maxBeauty, items[i][1]);
            items[i][1] = maxBeauty;
        }
        vector<int> result;
        for (int i = 0; i < queries.size(); i++) {
            int index = lower_bound(items.begin(), items.end(), vector<int>{queries[i]+1, 0}) - items.begin();
            if (index == 0) {
                result.push_back(0);
            } else {
                result.push_back(items[index-1][1]);
            }
        }
        return result;
    }
};