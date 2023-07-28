class Solution {
public:
    bool canCross(vector<int>& stones) {
        
        if (stones[1] != 1) return false;
        if (stones.size() == 2) return true;
        unordered_map<int, unordered_set<int>> m;
        m[1].insert(1);
        for (int i = 1; i < stones.size(); ++i) {
            for (auto j : m[stones[i]]) {
                for (int k = j - 1; k <= j + 1; ++k) {
                    if (k > 0 && m.find(stones[i] + k) != m.end()) {
                        m[stones[i] + k].insert(k);
                    }
                }
            }
        }
        return m[stones.back()].size() > 0;
    }
};