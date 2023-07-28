class Solution {
public:
    string capitalizeTitle(string title) {
        
        int i = 0;
        while (i < title.size()) {
            while (i < title.size() && title[i] == ' ')
                i++;
            if (i < title.size())
                title[i] = toupper(title[i]);
            i++;
            while (i < title.size() && title[i] != ' ') {
                title[i] = tolower(title[i]);
                i++;
            }
        }
        return title;
    }
};