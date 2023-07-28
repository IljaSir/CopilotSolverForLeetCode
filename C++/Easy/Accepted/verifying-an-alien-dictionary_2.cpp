class Solution {
public:
    bool isAlienSorted(vector<string>& words, string order) {
        
        int order_map[26];
        for (int i = 0; i < order.size(); i++) {
            order_map[order[i] - 'a'] = i;
        }
        for (int i = 0; i < words.size() - 1; i++) {
            if (!compare(words[i], words[i+1], order_map)) {
                return false;
            }
        }
        return true;
    }
    
    bool compare(string word1, string word2, int order_map[]) {
        int len = min(word1.size(), word2.size());
        for (int i = 0; i < len; i++) {
            if (word1[i] != word2[i]) {
                return order_map[word1[i] - 'a'] < order_map[word2[i] - 'a'];
            }
        }
        return word1.size() <= word2.size();
    }
};