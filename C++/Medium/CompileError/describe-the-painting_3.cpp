class Solution {
public:
    vector<vector<long long>> splitPainting(vector<vector<int>>& segments) {
        
        map<int, int> m;
        for (auto& s : segments) {
            m[s[0]] += s[2];
            m[s[1]] -= s[2];
        }
        vector<vector<long long>> res;
        int l = 0, r = 0, c = 0;
        for (auto& p : m) {
            int x = p.first, y = p.second;
            if (c > 0) {
                ans.push_back({prev, p.first, sum});
            }
            l, x = p.first;
            sum += p.second;
        }
        return res;
    }
};