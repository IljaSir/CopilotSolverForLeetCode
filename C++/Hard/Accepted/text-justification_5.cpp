class Solution {
public:
    vector<string> fullJustify(vector<string>& words, int maxWidth) {
        
        vector<string> result;
        int n = words.size();
        int i = 0;
        while(i < n) {
            int j = i + 1;
            int len = words[i].length();
            while(j < n && len + words[j].length() + j - i <= maxWidth) {
                len += words[j++].length();
            }
            int space = 1;
            int extra = 0;
            if(j < n && j - i - 1 > 0) {
                space = (maxWidth - len) / (j - i - 1);
                extra = (maxWidth - len) % (j - i - 1);
            }
            string line = words[i];
            for(int k = i + 1; k < j; k++) {
                line += string(space, ' ');
                if(extra-- > 0) {
                    line += ' ';
                }
                line += words[k];
            }
            line += string(maxWidth - line.length(), ' ');
            result.push_back(line);
            i = j;
        }
        return result;
    }
};