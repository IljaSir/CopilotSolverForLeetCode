class Solution {
public:
    vector<vector<long long>> splitPainting(vector<vector<int>>& segments) {
        
        vector<vector<long long>> result;
        map<int, long long> m;
        for (auto& segment : segments) {
            m[segment[0]] += segment[2];
            m[segment[1]] -= segment[2];
        }
        long long sum = 0;
        int start = 0;
        for (auto& [pos, color] : m) {
            if (sum > 0) {
                result.push_back({start, pos, sum});
            }
            start = pos;
            sum += color;
        }
        return result;
    }
};