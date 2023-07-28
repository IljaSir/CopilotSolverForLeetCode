class Solution {
public:
    vector<vector<int>> getSkyline(vector<vector<int>>& buildings) {
        
        vector<vector<int>> res;
        multiset<pair<int, int>> points;
        for (auto& b : buildings) {
            points.insert(make_pair(b[0], -b[2]));
            points.insert(make_pair(b[1], b[2]));
        }
        multiset<int> heights = {0};
        vector<int> last = {0, 0};
        for (auto& p : points) {
            if (p.second < 0) heights.insert(-p.second);
            else heights.erase(heights.find(p.second));
            auto maxHeight = *heights.rbegin();
            if (last[1] != maxHeight) {
                last[0] = p.first;
                last[1] = maxHeight;
                res.push_back(last);
            }
        }
        return res;
    }
};