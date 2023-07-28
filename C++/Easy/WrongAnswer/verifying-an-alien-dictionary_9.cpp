class Solution {
public:
    bool isAlienSorted(vector<string>& words, string order) {
        
        int n = words.size();
        if (n == 1) return true;
        int m = words[0].size();
        for (int i = 1; i < n; i++) {
            if (words[i].size() < m) m = words[i].size();
        }
        int pos[26];
        for (int i = 0; i < 26; i++) {
            pos[order[i] - 'a'] = i;
        }
        for (int i = 1; i < n; i++) {
            int j = 0;
            while (j < m && words[i-1][j] == words[i][j]) j++;
            if (j == m) {
                if (words[i-1].size() > words[i].size()) return false;
            } else {
                if (pos[words[i-1][j] - 'a'] > pos[words[i][j] - 'a']) return false;
            }
        }
        return true;
    }
};