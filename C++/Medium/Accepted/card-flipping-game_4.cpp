class Solution {
public:
    int flipgame(vector<int>& fronts, vector<int>& backs) {
        
        unordered_set<int> s;
        int n = fronts.size();
        for (int i = 0; i < n; i++) {
            if (fronts[i] == backs[i]) {
                s.insert(fronts[i]);
            }
        }
        int res = 2000;
        for (int i = 0; i < n; i++) {
            if (s.find(fronts[i]) == s.end()) {
                res = min(res, fronts[i]);
            }
            if (s.find(backs[i]) == s.end()) {
                res = min(res, backs[i]);
            }
        }
        return res == 2000 ? 0 : res;
    }
};