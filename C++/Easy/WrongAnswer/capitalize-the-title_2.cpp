class Solution {
public:
    string capitalizeTitle(string title) {
        
        bool space = true;
        for(auto& c : title) {
            if (space) {
                c = toupper(c);
                space = false;
            } else {
                c = tolower(c);
            }
            if (c == ' ') {
                space = true;
            }
        }
        return title;
    }
};