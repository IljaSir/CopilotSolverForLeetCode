class Solution {
public:
    vector<int> maximumBeauty(vector<vector<int>>& items, vector<int>& queries) {
        
        map<int, int> m;
        for (auto i: items) {
            m[i[0]] = max(m[i[0]], i[1]);
        }
        vector<int> v;
        int prev = 0;
        for (auto i: m) {
            v.push_back(i.second);
            prev = i.second;
        }
        vector<int> ans;
        for (auto i: queries) {
            int idx = upper_bound(v.begin(), v.end(), i) - v.begin();
            if (idx == 0) {
                ans.push_back(0);
            } else {
                ans.push_back(v[idx - 1]);
            }
        }
        return ans;
    }
};