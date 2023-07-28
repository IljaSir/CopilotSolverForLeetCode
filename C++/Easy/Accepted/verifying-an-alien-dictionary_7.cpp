class Solution {
public:
    bool isAlienSorted(vector<string>& words, string order) {
        
        int n = words.size();
        if (n == 1) return true;
        vector<int> order_map(26, 0);
        for (int i = 0; i < 26; i++) {
            order_map[order[i] - 'a'] = i;
        }
        for (int i = 0; i < n - 1; i++) {
            int j = 0;
            for (; j < words[i].length() && j < words[i + 1].length(); j++) {
                if (order_map[words[i][j] - 'a'] > order_map[words[i + 1][j] - 'a']) {
                    return false;
                } else if (order_map[words[i][j] - 'a'] < order_map[words[i + 1][j] - 'a']) {
                    break;
                }
            }
            if (j == words[i + 1].length() && j < words[i].length()) return false;
        }
        return true;
    }
};