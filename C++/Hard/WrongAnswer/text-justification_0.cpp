class Solution {
public:
    vector<string> fullJustify(vector<string>& words, int maxWidth) {
        
        vector<string> ans;
        int i = 0;
        while (i < words.size()) {
            int len = words[i].size();
            int j = i + 1;
            while (j < words.size()) {
                if (len + 1 + words[j].size() > maxWidth) break;
                len += 1 + words[j].size();
                ++j;
            }
            string s = words[i];
            int space = maxWidth - len;
            int each = 1, extra = 0;
            if (j - i - 1 > 0) {
                each = space / (j - i - 1);
                extra = space % (j - i - 1);
            }
            for (int k = i + 1; k < j; ++k) {
                s += string(each, ' ');
                if (extra > 0) {
                    s += ' ';
                    --extra;
                }
                s += words[k];
            }
            if (j - i == 1) s += string(space, ' ');
            ans.push_back(s);
            i = j;
        }
        return ans;
    }
};