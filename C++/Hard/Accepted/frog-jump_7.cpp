class Solution {
public:
    bool canCross(vector<int>& stones) {
        
        unordered_map<int, unordered_set<int>> m;
        for (auto x : stones) {
            m[x] = unordered_set<int>();
        }
        m[0].insert(1);
        for (auto x : stones) {
            for (auto step : m[x]) {
                int reach = x + step;
                if (reach == stones.back()) {
                    return true;
                }
                if (m.find(reach) != m.end()) {
                    m[reach].insert(step);
                    if (step > 1) {
                        m[reach].insert(step - 1);
                    }
                    m[reach].insert(step + 1);
                }
            }
        }
        return false;
    }
};