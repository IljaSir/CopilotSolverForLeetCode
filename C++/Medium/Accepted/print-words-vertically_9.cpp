class Solution {
public:
    vector<string> printVertically(string s) {
        
        vector<string> v;
        int i = 0, j = 0, maxLen = 0;
        while (i < s.size()) {
            string word;
            while (i < s.size() && s[i] != ' ') {
                word += s[i];
                i++;
            }
            if (word.size() > maxLen) {
                maxLen = word.size();
            }
            v.push_back(word);
            i++;
        }
        for (i = 0; i < v.size(); i++) {
            while (v[i].size() < maxLen) {
                v[i] += ' ';
            }
        }
        vector<string> ans;
        for (i = 0; i < maxLen; i++) {
            string line;
            for (j = 0; j < v.size(); j++) {
                line += v[j][i];
            }
            while (line[line.size() - 1] == ' ') {
                line.pop_back();
            }
            ans.push_back(line);
        }
        return ans;
    }
};