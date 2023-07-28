class Solution {
public:
    int expressiveWords(string s, vector<string>& words) {
        
        int n = s.size();
        int count = 0;
        for (auto word : words) {
            int i = 0;
            int j = 0;
            while (i < n && j < word.size()) {
                if (s[i] != word[j]) {
                    break;
                }
                int i1 = i;
                int j1 = j;
                while (i1 < n && s[i1] == s[i]) {
                    i1++;
                }
                while (j1 < word.size() && word[j1] == word[j]) {
                    j1++;
                }
                int n1 = i1 - i;
                int n2 = j1 - j;
                if (n1 < 3 && n1 != n2) {
                    break;
                }
                if (n1 >= 3 && n1 < n2) {
                    break;
                }
                i = i1;
                j = j1;
            }
            if (i == n && j == word.size()) {
                count++;
            }
        }
        return count;
    }
};