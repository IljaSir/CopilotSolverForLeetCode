class Solution {
public:
    string capitalizeTitle(string title) {
        
        string res = "";
        int n = title.size();
        for (int i = 0; i < n; i++) {
            if (title[i] == ' ') {
                res += ' ';
            } else {
                int j = i;
                while (j < n && title[j] != ' ') {
                    j++;
                }
                if (j - i <= 2) {
                    for (int k = i; k < j; k++) {
                        res += tolower(title[k]);
                    }
                } else {
                    res += toupper(title[i]);
                    for (int k = i + 1; k < j; k++) {
                        res += tolower(title[k]);
                    }
                }
                i = j - 1;
            }
        }
        return res;
    }
};