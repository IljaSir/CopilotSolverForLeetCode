class Solution {
public:
    vector<int> findNumOfValidWords(vector<string>& words, vector<string>& puzzles) {
        
        map<int, int> m;
        for (string& w: words) {
            int mask = 0;
            for (char c: w) {
                mask |= 1 << (c - 'a');
            }
            if (__builtin_popcount(mask) <= 7) {
                m[mask]++;
            }
        }
        vector<int> res;
        for (string& p: puzzles) {
            int total = 0;
            int mask = 0;
            for (int i = 1; i < 7; i++) {
                mask |= 1 << (p[i] - 'a');
            }
            int subset = mask;
            do {
                int s = subset | (1 << (p[0] - 'a'));
                if (m.count(s)) {
                    total += m[s];
                }
                subset = (subset - 1) & mask;
            } while (subset != mask);
            res.push_back(total);
        }
        return res;
    }
};