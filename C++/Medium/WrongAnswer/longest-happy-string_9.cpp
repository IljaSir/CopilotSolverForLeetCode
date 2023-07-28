class Solution {
public:
    string longestDiverseString(int a, int b, int c) {
        
        string result = "";
        int n = a+b+c;
        vector<pair<int, char>> v = {{a, 'a'}, {b, 'b'}, {c, 'c'}};
        for (int i = 0; i < n; ++i) {
            sort(v.begin(), v.end());
            if (v[2].first > 0 && (result.empty() || result.back() != v[2].second)) {
                result += v[2].second;
                --v[2].first;
            } else if (v[1].first > 0 && (result.empty() || result.back() != v[1].second)) {
                result += v[1].second;
                --v[1].first;
            } else if (v[0].first > 0 && (result.empty() || result.back() != v[0].second)) {
                result += v[0].second;
                --v[0].first;
            } else {
                break;
            }
        }
        return result;
    }
};