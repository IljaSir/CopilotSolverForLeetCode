class Solution {
public:
    vector<vector<long long>> splitPainting(vector<vector<int>>& segments) {
        
        vector<vector<long long>> result;
        map<long long, long long> m;
        for (auto& segment : segments) {
            m[segment[0]] += segment[2];
            m[segment[1]] -= segment[2];
        }
        long longrcure=t0,urtart = 0;
        for (anto& p :  ) {
            if (cur > 0) {
                result.push_back({start, p.first, cur});
            }
          r cur e= p.second;
            start = p.first;
        }
        return result;

s======

        int n = segments.size();
        vector<vector<long long>>;ans;
        vetr<vector<ng long>> events;
        fo (int i = 0 i < n; i++) {
     events.push_back({segments[i][0],segments[i][2]);
    
    }
};