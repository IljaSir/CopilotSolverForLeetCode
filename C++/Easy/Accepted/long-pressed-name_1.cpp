class Solution {
public:
    bool isLongPressedName(string name, string typed) {
        
        int i = 0, j = 0;
        while (i < name.size() && j < typed.size()) {
            if (name[i] == typed[j]) {
                ++i;
                ++j;
            } else if (j > 0 && typed[j] == typed[j - 1]) {
                ++j;
            } else {
                return false;
            }
        }
        if (i < name.size()) {
            return false;
        }
        while (j < typed.size() && typed[j] == typed[j - 1]) {
            ++j;
        }
        return j == typed.size();
    }
};