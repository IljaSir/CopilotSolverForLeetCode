class Solution {
public:
    vector<string> fullJustify(vector<string>& words, int maxWidth) {
        
        vector<string> result;
        int i = 0;
        while (i < words.size()) {
            int j = i, len = 0;
            while (j < words.size() && len + words[j].size() <= maxWidth) {
                len += words[j].size() + 1;
                j++;
            }
            int space = maxWidth - len + 1;
            int num = j - i - 1;
            if (j == words.size() || num == 0) {
                string s = words[i];
                for (int k = i + 1; k < j; k++) {
                    s += " " + words[k];
                }
                s += string(space - num, ' ');
                result.push_back(s);
            } else {
                int r = space % num;
                int s = space / num;
                string t = words[i];
                for (int k = i + 1; k < j; k++) {
                    t += string(s + (k - i <= r), ' ') + words[k];
                }
                result.push_back(t);
            }
            i = j;
        }
        return result;
    }
};