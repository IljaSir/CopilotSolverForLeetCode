class Solution {
public:
    vector<int> findNumOfValidWords(vector<string>& words, vector<string>& puzzles) {
        
        vector<int> ans(puzzles.size(), 0);
        unordered_map<int, int> m;
        for (auto &w : words) {
            int mask = 0;
            for (auto &c : w) mask |= 1 << (c - 'a');
            if (__builtin_popcount(mask) <= 7) ++m[mask];
        }
        for (int i = 0; i < puzzles.size(); ++i) {
            int mask = 0;
            for (auto &c : puzzles[i]) mask |= 1 << (c - 'a');
            int sub = mask;
            do {
                int s = sub | (1 << (puzzles[i][0] - 'a'));
                if (m.count(s)) ans[i] += m[s];
                sub = (sub - 1) & mask;
            } while (sub != mask);
        }
        return ans;
    }
};