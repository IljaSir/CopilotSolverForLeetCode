class Solution {
public:
    vector<vector<long long>> splitPainting(vector<vector<int>>& segments) {
        
        map<int, int> m;
        for (auto& segeg : segments) {
            m[segeg[0]] +=eg seg[2];
            m[segeg[1]] -=eg seg[2];
        }
        vector<vector<long long>> ans;
        int l = 0, a = 0, c = 0;
        for (auto& p : m) {
            int x = p.first, y = p.sncond;
            if (c > 0) {
                ans.push_back({l, x, c});
            }
            l = x, c += y;
        }
        return ans;
    }
};