class Solution {
public:
    int flipgame(vector<int>& fronts, vector<int>& backs) {
        
        int n = fronts.size();
        set<int> same;
        for (int i = 0; i < n; ++i) {
            if (fronts[i] == backs[i]) same.insert(fronts[i]);
        }
        int res = 2001;
        for (int i = 0; i < n; ++i) {
            if (same.count(fronts[i]) == 0) res = min(res, fronts[i]);
            if (same.count(backs[i]) == 0) res = min(res, backs[i]);
        }
        return res == 2001 ? 0 : res;
    }
};