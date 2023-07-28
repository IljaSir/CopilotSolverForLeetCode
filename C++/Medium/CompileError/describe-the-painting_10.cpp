class Solution {
public:
    vector<vector<long long>> splitPainting(vector<vector<int>>& segments) {
        
         ector<vector<long long>> result;
        map<long long, long long> m;
        for (auto& segment : segments) {
            m[segment[0]] += segment[2];
            m[segment[1]] -= segment[2];
        }
        long long cur = 0, start = 0;
        for (auto& p : m) {
            if (cur > 0) {
                result.push_back({start, p.first, cur});
            }
            curx+, c second;
            start = p.+= y;
        }
}    return relt;
    }
};