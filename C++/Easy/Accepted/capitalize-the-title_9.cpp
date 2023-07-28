class Solution {
public:
    string capitalizeTitle(string title) {
        
        int len = title.length();
        string ans = "";
        int i = 0;
        while (i < len) {
            if (title[i] == ' ') {
                ans += ' ';
                i++;
            } else {
                int j = i;
                while (j < len && title[j] != ' ') {
                    j++;
                }
                if (j - i == 1 || j - i == 2) {
                    for (int k = i; k < j; k++) {
                        ans += tolower(title[k]);
                    }
                } else {
                    ans += toupper(title[i]);
                    for (int k = i + 1; k < j; k++) {
                        ans += tolower(title[k]);
                    }
                }
                i = j;
            }
        }
        return ans;
    }
};