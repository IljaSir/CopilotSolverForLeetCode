class Solution {
public:
    vector<string> sortPeople(vector<string>& names, vector<int>& heights) {
        
        vector<pair<int, string>> h;
        for (int i = 0; i < heights.size(); ++i) {
            h.push_back({heights[i], names[i]});
        }
        sort(h.begin(), h.end(), [](auto& a, auto& b) {
            return a.first > b.first;
        });
        vector<string> res;
        for (auto& p : h) {
            res.push_back(p.second);
        }
        return res;
    }
};