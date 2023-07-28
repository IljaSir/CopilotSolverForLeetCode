class Solution {
public:
    string capitalizeTitle(string title) {
        
        string result = "";
        int n = title.size();
        int i = 0;
        while (i < n) {
            if (i == 0 || title[i - 1] == ' ') {
                if (i + 1 < n) {
                    result += toupper(title[i]);
                    result += tolower(title[i + 1]);
                    i += 2;
                } else {
                    result += toupper(title[i]);
                    i++;
                }
            } else {
                result += tolower(title[i]);
                i++;
            }
        }
        return result;
    }
};