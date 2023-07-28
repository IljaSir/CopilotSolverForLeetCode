class Solution {
public:
    int numEquivDominoPairs(vector<vector<int>>& dominoes) {
        
        map<pair<int, int>, int> m;
        for (auto d : dominoes) {
            if (d[0] > d[1]) swap(d[0], d[1]);
            m[make_pair(d[0], d[1])]++;
        }
        int res = 0;
        for (auto it = m.begin(); it != m.end(); it++) {
            res += it->second * (it->second - 1) / 2;
        }
        return res;
    }
};