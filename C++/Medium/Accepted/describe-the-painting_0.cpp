class Solution {
public:
    vector<vector<long long>> splitPainting(vector<vector<int>>& segments) {
        
        map<int, long long> m;
        for (auto& s : segments) {
            m[s[0]] += s[2];
            m[s[1]] -= s[2];
        }
        vector<vector<long long>> ans;
        long long sum = 0;
        int start = 0;
        for (auto& p : m) {
            if (sum > 0) ans.push_back({start, p.first, sum});
            sum += p.second;
            start = p.first;
        }
        return ans;
    }
};