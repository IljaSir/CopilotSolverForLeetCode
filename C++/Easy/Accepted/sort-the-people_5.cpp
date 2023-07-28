class Solution {
public:
    vector<string> sortPeople(vector<string>& names, vector<int>& heights) {
        
        vector<string> res;
        vector<pair<int, string>> v;
        for (int i = 0; i < names.size(); i++) {
            v.push_back(make_pair(heights[i], names[i]));
        }
        sort(v.begin(), v.end(), [](pair<int, string> a, pair<int, string> b) {
            if (a.first != b.first) {
                return a.first > b.first;
            }
            return a.second < b.second;
        });
        for (auto p : v) {
            res.push_back(p.second);
        }
        return res;
    }
};