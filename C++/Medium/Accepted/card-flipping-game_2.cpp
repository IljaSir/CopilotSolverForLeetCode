class Solution {
public:
    int flipgame(vector<int>& fronts, vector<int>& backs) {
        
        unordered_set<int> bad;
        for (int i = 0; i < fronts.size(); ++i) {
            if (fronts[i] == backs[i]) {
                bad.insert(fronts[i]);
            }
        }
        int res = 2001;
        for (int i = 0; i < fronts.size(); ++i) {
            if (!bad.count(fronts[i])) {
                res = min(res, fronts[i]);
            }
            if (!bad.count(backs[i])) {
                res = min(res, backs[i]);
            }
        }
        return res == 2001 ? 0 : res;
    }
};