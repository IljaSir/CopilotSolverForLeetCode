class Solution {
public:
    int flipgame(vector<int>& fronts, vector<int>& backs) {
        
        unordered_set<int> same;
        for (int i = 0; i < fronts.size(); i++) {
            if (fronts[i] == backs[i]) {
                same.insert(fronts[i]);
            }
        }
        int min = 2000;
        for (int i = 0; i < fronts.size(); i++) {
            if (same.find(fronts[i]) == same.end()) {
                if (min > fronts[i]) {
                    min = fronts[i];
                }
            }
            if (same.find(backs[i]) == same.end()) {
                if (min > backs[i]) {
                    min = backs[i];
                }
            }
        }
        return min == 2000 ? 0 : min;
    }
};