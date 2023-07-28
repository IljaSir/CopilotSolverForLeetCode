class Solution {
public:
    vector<int> maximumBeauty(vector<vector<int>>& items, vector<int>& queries) {
        
        vector<int> result;
        sort(items.begin(), items.end(), [](vector<int> a, vector<int> b) {
            return a[0] < b[0];
        });
        int maxBeauty = 0;
        for (int i = 0; i < items.size(); i++) {
            maxBeauty = max(maxBeauty, items[i][1]);
            items[i][1] = maxBeauty;
        }
        for (int i = 0; i < queries.size(); i++) {
            int q = queries[i];
            int l = 0, r = items.size() - 1;
            while (l < r) {
                int mid = (l + r + 1) / 2;
                if (items[mid][0] > q) {
                    r = mid - 1;
                } else {
                    l = mid;
                }
            }
            if (items[l][0] <= q) {
                result.push_back(items[l][1]);
            } else {
                result.push_back(0);
            }
        }
        return result;
    }
};