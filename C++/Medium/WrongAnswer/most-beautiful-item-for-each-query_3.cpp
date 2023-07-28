class Solution {
public:
    vector<int> maximumBeauty(vector<vector<int>>& items, vector<int>& queries) {
        
        vector<int> ans;
        vector<int> v;
        for (int i = 0; i < items.size(); i++) {
            v.push_back(items[i][1]);
        }
        sort(v.begin(), v.end());
        for (int i = 0; i < queries.size(); i++) {
            int l = 0, r = v.size() - 1;
            int res = 0;
            while (l <= r) {
                int m = l + (r - l) / 2;
                if (v[m] <= queries[i]) {
                    res = v[m];
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            ans.push_back(res);
        }
        return ans;
    }
};