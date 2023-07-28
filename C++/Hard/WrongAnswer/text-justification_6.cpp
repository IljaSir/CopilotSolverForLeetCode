class Solution {
public:
    vector<string> fullJustify(vector<string>& words, int maxWidth) {
        
        vector<string> ans;
        int i = 0;
        while (i < words.size()) {
            int left = i;
            int len = 0;
            while (i < words.size() && len + words[i].size() <= maxWidth) {
                len += words[i].size() + 1;
                i++;
            }
            int right = i - 1;
            int space = maxWidth - len + 1;
            if (left == right) {
                ans.push_back(words[left] + string(space, ' '));
                continue;
            }
            if (i == words.size()) {
                string s = words[left++];
                while (left <= right) {
                    s += ' ' + words[left++];
                }
                s += string(space - 1, ' ');
                ans.push_back(s);
                continue;
            }
            int wordsNum = right - left + 1;
            int spaceNum = space / wordsNum;
            int extra = space % wordsNum;
            string s = words[left++];
            while (left <= right) {
                s += string(spaceNum + (extra-- > 0 ? 1 : 0), ' ') + words[left++];
            }
            ans.push_back(s);
        }
        return ans;
    }
};