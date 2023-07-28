class Solution {
public:
    bool isAlienSorted(vector<string>& words, string order) {
        
        unordered_map<char, int> dict;
        for (int i = 0; i < order.size(); ++i) {
            dict[order[i]] = i;
        }
        
        for (int i = 0; i < words.size() - 1; ++i) {
            for (int j = 0; j < words[i].size(); ++j) {
                if (j == words[i + 1].size()) {
                    return false;
                }
                if (words[i][j] != words[i + 1][j]) {
                    if (dict[words[i][j]] > dict[words[i + 1][j]]) {
                        return false;
                    } else {
                        break;
                    }
                }
            }
        }
        return true;
    }
};