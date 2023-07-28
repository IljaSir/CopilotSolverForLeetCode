class Solution {
public:
    vector<vector<int>> getSkyline(vector<vector<int>>& buildings) {
        
        multiset<pair<int, int>> events;
        for (auto& b: buildings) {
            events.insert({b[0], -b[2]});
            events.insert({b[1], b[2]});
        }
        multiset<int> heights({0});
        vector<vector<int>> res;
        int prev = 0, curr = 0;
        for (auto& e: events) {
            if (e.second < 0) heights.insert(-e.second);
            else heights.erase(heights.find(e.second));
            curr = *heights.rbegin();
            if (curr != prev) {
                res.push_back({e.first, curr});
                prev = curr;
            }
        }
        return res;
    }
};