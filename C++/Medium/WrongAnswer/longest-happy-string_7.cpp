class Solution {
public:
    string longestDiverseString(int a, int b, int c) {
        
        vector<pair<int, char>> v = {{a, 'a'}, {b, 'b'}, {c, 'c'}};
        string ans;
        while (true) {
            sort(v.begin(), v.end(), greater<pair<int, char>>());
            if (v[0].first == 0) break;
            if (v[0].first >= 2 && v[1].first >= 1 && v[0].second != ans.back()) {
                ans.push_back(v[0].second);
                ans.push_back(v[0].second);
                ans.push_back(v[1].second);
                v[0].first -= 2;
                v[1].first -= 1;
            } else {
                ans.push_back(v[0].second);
                v[0].first -= 1;
            }
        }
        return ans;
    }
};