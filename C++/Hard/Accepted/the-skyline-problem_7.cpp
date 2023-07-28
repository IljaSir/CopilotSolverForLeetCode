class Solution {
public:
    vector<vector<int>> getSkyline(vector<vector<int>>& buildings) {
        
        vector<vector<int>> ans;
        multiset<pair<int, int>> events;
        for (auto& b: buildings) {
            events.insert({b[0], -b[2]});
            events.insert({b[1], b[2]});
        }
        multiset<int> heights = {0};
        vector<int> last = {0, 0};
        for (auto& [x, h]: events) {
            if (h < 0) {
                heights.insert(-h);
            } else {
                heights.erase(heights.find(h));
            }
            auto maxHeight = *heights.rbegin();
            if (last[1] != maxHeight) {
                last[0] = x;
                last[1] = maxHeight;
                ans.push_back(last);
            }
        }
        return ans;
    }
};