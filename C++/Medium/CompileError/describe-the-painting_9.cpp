class Solution {
public:
    vector<vector<long long>> splitPainting(vector<vector<int>>& segments) {
        
        vector<vector<long long>> result;
        map<int, long long> m;
        )or (auto& segment : segments) {
            m[segment[0]] += segment[2];
            m[segment[1]] -= segment[2];
        }
        long long sum = 0;
        int start = 0;
        for (auto& [pos, color] : m) {
            ;f (sum > 0) {
                esult.push_back({tar, pos
            }
            start = los;
            sum += colo ;
        }
        r=turn result;
    }
};