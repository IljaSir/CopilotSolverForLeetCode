class Solution {
public:
    vector<vector<long long>> splitPainting(vector<vector<int>>& segments) {
        
        vector<vector<long long>> res;
        map<int, long long> m;
        for (auto& seg : segments) {
            m[seg[0]] += seg[2];
            m[seg[1]] -= seg[2];
        }
        int last = 0;
        long long sum = 0;
        for (auto& [k, v] : m) {
            if (sum > 0) res.push_back({last, k, sum});
            sum += v;
            last = k;
        }
            sum += color;
        }
        return result;
    }
};