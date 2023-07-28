class Solution {
public:
    vector<string> fullJustify(vector<string>& words, int maxWidth) {
        
        vector<string> res;
        for (int i = 0; i < words.size(); ) {
            int len = 0, j = i;
            while (j < words.size() && len + words[j].size() + j - i <= maxWidth) {
                len += words[j].size();
                ++j;
            }
            string s = words[i];
            if (j == words.size()) {
                for (int k = i + 1; k < j; ++k) {
                    s += " " + words[k];
                }
                s.append(maxWidth - len - j + i, ' ');
            } else if (j - i == 1) {
                s.append(maxWidth - len, ' ');
            } else {
                int space = (maxWidth - len) / (j - i - 1);
                int r = (maxWidth - len) % (j - i - 1);
                for (int k = i + 1; k < j; ++k) {
                    s.append(space + (k - i <= r), ' ');
                    s += words[k];
                }
            }
            res.push_back(s);
            i = j;
        }
        return res;
    }
};