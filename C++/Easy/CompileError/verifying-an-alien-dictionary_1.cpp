class Solution {
public:
    bool isAlienSorted(vector<string>& words, string order) {
        
        vector<int> table(26);
        for (int i = 0; i < order.size(); i++) {
            table[order[i] - 'a'] = i;
        }
        for (int i = 0; i < words.size() - 1; i++) {
            if (!isSorted(words[i], words[i + 1], table)) return false;
        }
        return true;
    }
};