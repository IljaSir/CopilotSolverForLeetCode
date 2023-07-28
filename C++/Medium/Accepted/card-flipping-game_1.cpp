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
            if (bad.find(fronts[i]) == bad.end()) {
                res = min(res, fronts[i]);
            }
            if (bad.find(backs[i]) == bad.end()) {
                res = min(res, backs[i]);
            }
        }
        return res % 2001;
    }
};