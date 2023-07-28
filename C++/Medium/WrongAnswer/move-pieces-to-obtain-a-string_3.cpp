class Solution {
public:
    bool canChange(string start, string target) {
        
        int n = start.size();
        int i = 0, j = 0;
        while (i < n && j < n) {
            if (start[i] == '_') {
                i++;
                continue;
            }
            if (target[j] == '_') {
                j++;
                continue;
            }
            if (start[i] != target[j]) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }
};