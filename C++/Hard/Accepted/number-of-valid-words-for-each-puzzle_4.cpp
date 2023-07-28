class Solution {
public:
    vector<int> findNumOfValidWords(vector<string>& words, vector<string>& puzzles) {
        
        vector<int> ans(puzzles.size(), 0);
        vector<int> mask(words.size(), 0);
        vector<int> count(1 << 26, 0);
        for (int i = 0; i < words.size(); i++) {
            for (char c : words[i]) {
                mask[i] |= (1 << (c - 'a'));
            }
            count[mask[i]]++;
        }
        for (int i = 0; i < puzzles.size(); i++) {
            int first = 1 << (puzzles[i][0] - 'a');
            for (int j = 0; j < (1 << 6); j++) {
                int mask = first;
                for (int k = 0; k < 6; k++) {
                    if (j & (1 << k)) {
                        mask |= (1 << (puzzles[i][k + 1] - 'a'));
                    }
                }
                ans[i] += count[mask];
            }
        }
        return ans;
    }
};