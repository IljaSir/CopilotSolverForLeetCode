class Solution {
public:
    vector<int> maximumBeauty(vector<vector<int>>& items, vector<int>& queries) {
        
        sort(items.begin(), items.end());
        vector<int> res;
        int n = items.size();
        int m = queries.size();
        int i = 0;
        for (int j = 0; j < m; j++) {
            while (i < n && queries[j] >= items[i][0]) {
                if (i == 0 || items[i][1] > items[i - 1][1]) {
                    items[i][1] = max(items[i][1], i > 0 ? items[i - 1][1] : 0);
                }
                i++;
            }
            res.push_back(i > 0 ? items[i - 1][1] : 0);
        }
        return res;
    }
};