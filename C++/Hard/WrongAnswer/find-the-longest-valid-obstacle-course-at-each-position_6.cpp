class Solution {
public:
    vector<int> longestObstacleCourseAtEachPosition(vector<int>& obstacles) {
        
        vector<int> res;
        set<int> s;
        for (int i = 0; i < obstacles.size(); ++i) {
            auto it = s.upper_bound(obstacles[i]);
            if (it != s.end()) {
                s.erase(it);
            }
            s.insert(obstacles[i]);
            res.push_back(s.size());
        }
        return res;
    }
};