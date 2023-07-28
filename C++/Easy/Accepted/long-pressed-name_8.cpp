class Solution {
public:
    bool isLongPressedName(string name, string typed) {
        
        int i = 0;
        int j = 0;
        int n = name.size();
        int m = typed.size();
        if (n > m) {
            return false;
        }
        while (i < n && j < m) {
            if (name[i] == typed[j]) {
                ++i;
                ++j;
            } else {
                if (j > 0 && typed[j] == typed[j - 1]) {
                    ++j;
                } else {
                    return false;
                }
            }
        }
        if (i < n) {
            return false;
        }
        while (j < m) {
            if (typed[j] != typed[j - 1]) {
                return false;
            }
            ++j;
        }
        return true;
    }
};