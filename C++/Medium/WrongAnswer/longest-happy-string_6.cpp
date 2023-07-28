class Solution {
public:
    string longestDiverseString(int a, int b, int c) {
        
        string res;
        vector<pair<int, char>> v = {{a, 'a'}, {b, 'b'}, {c, 'c'}};
        while (true) {
            sort(v.rbegin(), v.rend());
            if (v[0].first == 0) break;
            if (v[0].first >= 2 && v[1].first >= 1 && (res.empty() || res.back() != v[0].second || res[res.size() - 2] != v[0].second)) {
                res.push_back(v[0].second);
                res.push_back(v[0].second);
                v[0].first -= 2;
            } else {
                res.push_back(v[0].second);
                v[0].first -= 1;
            }
        }
        return res;
    }
};