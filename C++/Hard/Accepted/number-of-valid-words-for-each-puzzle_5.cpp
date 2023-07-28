class Solution {
public:
    vector<int> findNumOfValidWords(vector<string>& words, vector<string>& puzzles) {
        
        vector<int> res;
        unordered_map<int, int> cnt;
        for (auto w:words) {
            int mask = 0;
            for (auto c:w) {
                mask |= 1 << (c - 'a');
            }
            if (__builtin_popcount(mask) <= 7) {
                cnt[mask]++;
            }
        }
        for (auto p:puzzles) {
            int total = 0;
            for (int choose = 0; choose < (1 << 6); ++choose) {
                int mask = 0;
                for (int i = 0; i < 6; ++i) {
                    if (choose & (1 << i)) {
                        mask |= 1 << (p[i + 1] - 'a');
                    }
                }
                mask |= 1 << (p[0] - 'a');
                if (cnt.count(mask)) {
                    total += cnt[mask];
                }
            }
            res.push_back(total);
        }
        return res;
    }
};