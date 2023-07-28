class Solution {
public:
    string capitalizeTitle(string title) {
        
        bool capitalize = true;
        for (auto &c : title) {
            if (capitalize) {
                if (c >= 'a' && c <= 'z') {
                    c -= 'a' - 'A';
                }
                capitalize = false;
            }
            if (c == ' ') {
                capitalize = true;
            }
        }
        return title;
    }
};