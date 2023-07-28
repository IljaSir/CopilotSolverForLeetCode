class Solution {
public:
    bool isAlienSorted(vector<string>& words, string order) {
        
        int n = words.size();
        if (n == 1) return true;
        int m = order.size();
        unordered_map<char, int> map;
        for (int i = 0; i < m; i++) {
            map[order[i]] = i;
        }
        for (int i = 0; i < n - 1; i++) {
            int j = 0;
            while (j < words[i].size() && j < words[i + 1].size()) {
                if (map[words[i][j]] < map[words[i + 1][j]]) break;
                if (map[words[i][j]] > map[words[i + 1][j]]) return false;
                j++;
            }
            if (j == words[i].size() && j < words[i + 1].size()) return false;
        }
        return true;
    }
};