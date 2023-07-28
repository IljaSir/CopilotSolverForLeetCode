class Solution {
public:
    bool canCross(vector<int>& stones) {
        
        unordered_map<int, unordered_set<int>> m;
        for (int i = 0; i < stones.size(); ++i) {
            m[stones[i]] = unordered_set<int>();
        }
        m[0].insert(1);
        for (int i = 0; i < stones.size(); ++i) {
            for (auto& k : m[stones[i]]) {
                for (int step = k - 1; step <= k + 1; ++step) {
                    if (step > 0 && m.count(stones[i] + step)) {
                        m[stones[i] + step].insert(step);
                    }
                }
            }
        }
        return !m[stones.back()].empty();
    }
};