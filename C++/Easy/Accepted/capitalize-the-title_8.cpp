class Solution {
public:
    string capitalizeTitle(string title) {
        
        string result;
        int i = 0;
        while(i < title.size()) {
            int j = i;
            while(j < title.size() && title[j] != ' ') j++;
            if(j - i <= 2) {
                for(int k = i; k < j; k++) {
                    result += tolower(title[k]);
                }
            } else {
                result += toupper(title[i]);
                for(int k = i + 1; k < j; k++) {
                    result += tolower(title[k]);
                }
            }
            if(j < title.size()) result += ' ';
            i = j + 1;
        }
        return result;
    }
};