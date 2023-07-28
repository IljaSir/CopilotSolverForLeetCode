class Solution {
public:
    vector<string> fullJustify(vector<string>& words, int maxWidth) {
        
        vector<string> res;
        int i = 0;
        while (i < words.size()) {
            int line_length = words[i].size();
            int j = i + 1;
            while (j < words.size() && line_length + 1 + words[j].size() <= maxWidth) {
                line_length += 1 + words[j].size();
                j++;
            }
            string line = words[i];
            if (j == words.size() || j == i + 1) {
                for (int k = i + 1; k < j; k++) {
                    line += " " + words[k];
                }
                line += string(maxWidth - line.size(), ' ');
            } else {
                int num_space = maxWidth - line_length;
                int num_space_between = num_space / (j - i - 1);
                int num_extra_space = num_space % (j - i - 1);
                for (int k = i + 1; k < j; k++) {
                    line += string(num_space_between, ' ');
                    if (num_extra_space > 0) {
                        line += " ";
                        num_extra_space--;
                    }
                    line += " " + words[k];
                }
            }
            res.push_back(line);
            i = j;
        }
        return res;
    }
};