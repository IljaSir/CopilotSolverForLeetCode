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
        int res = 2001;
        for (int i = 0; i < n; i++) {
            if (s.count(fronts[i]) == 0) {
                res = min(res, fronts[i]);
            }
            if (s.count(backs[i]) == 0) {
                res = min(res, backs[i]);
            }
        }
        return res == 2001 ? 0 : res;
    }
};