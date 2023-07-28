class Solution {
public:
    int flipgame(vector<int>& fronts, vector<int>& backs) {
        
        int n = fronts.size();
        unordered_set<int> s;
        for (int i = 0; i < n; i++) {
            if (fronts[i] == backs[i]) s.insert(fronts[i]);
        }
        int res = INT_MAX;
        for (int i = 0; i < n; i++) {
            if (s.count(fronts[i]) == 0) res = min(res, fronts[i]);
            if (s.count(backs[i]) == 0) res = min(res, backs[i]);
        }
        return res == INT_MAX ? 0 : res;
    }
};