class Solution {
public:
    vector<vector<long long>> splitPainting(vector<vector<int>>& segments) {
        
        map<int, int> m;
        for (auto& s : segments) {
            m[s[0]] += s[2];
            m[s[1]] -= s[2];
        }
        vector<vector<long long>> res;
        int prev = -1;
        int sum = 0;
        for (auto& p : m) {
            if (prev > 0 && sum > 0) {
                res.push_back({prev, p.first, sum});
            }
            prev = p.first;
            sum += p.second;
        }
        return res;
    }
};