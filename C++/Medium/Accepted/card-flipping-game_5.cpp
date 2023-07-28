class Solution {
public:
    int flipgame(vector<int>& fronts, vector<int>& backs) {
        
        unordered_set<int> same;
        int n = fronts.size();
        for (int i = 0; i < n; ++i) {
            if (fronts[i] == backs[i]) {
                same.insert(fronts[i]);
            }
        }
        int res = INT_MAX;
        for (int i = 0; i < n; ++i) {
            if (!same.count(fronts[i])) {
                res = min(res, fronts[i]);
            }
            if (!same.count(backs[i])) {
                res = min(res, backs[i]);
            }
        }
        return res == INT_MAX ? 0 : res;
    }
};