class Solution {
public:
    string longestDiverseString(int a, int b, int c) {
        
        string res = "";
        vector<pair<int, char>> v;
        v.push_back(make_pair(a, 'a'));
        v.push_back(make_pair(b, 'b'));
        v.push_back(make_pair(c, 'c'));
        while (true) {
            sort(v.begin(), v.end());
            if (v[2].first == 0) break;
            if (v[2].first >= 2 && v[1].first == 0) {
                res += string(2, v[2].second);
                v[2].first -= 2;
            } else if (v[2].first >= 1 && v[1].first >= 1) {
                res += v[2].second;
                res += v[1].second;
                v[2].first -= 1;
                v[1].first -= 1;
            } else if (v[2].first >= 1 && v[1].first == 0) {
                res += v[2].second;
                v[2].first -= 1;
            }
        }
        return res;
    }
};