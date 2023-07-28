class Solution {
public:
    vector<int> findNumOfValidWords(vector<string>& words, vector<string>& puzzles) {
        
        vector<int> result;
        map<int, int> wordMap;
        for (auto word : words) {
            int mask = 0;
            for (auto c : word) {
                mask |= 1 << (c - 'a');
            }
            if (__builtin_popcount(mask) <= 7) {
                wordMap[mask]++;
            }
        }
        for (auto puzzle : puzzles) {
            int total = 0;
            int mask = 0;
            for (auto c : puzzle) {
                mask |= 1 << (c - 'a');
            }
            int subset = mask;
            do {
                int s = subset | (1 << (puzzle[0] - 'a'));
                if (wordMap.find(s) != wordMap.end()) {
                    total += wordMap[s];
                }
                subset = (subset - 1) & mask;
            } while (subset != mask);
            result.push_back(total);
        }
        return result;
    }
};