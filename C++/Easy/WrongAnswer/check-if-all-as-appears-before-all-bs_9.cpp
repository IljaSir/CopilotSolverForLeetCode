class Solution {
public:
    bool checkString(string s) {
        
        int n = s.size();
        int i = 0, j = 0;
        for (i = 0; i < n; i++) {
            if (s[i] == 'a') {
                break;
            }
        }
        for (j = i; j < n; j++) {
            if (s[j] == 'b') {
                break;
            }
        }
        for (int k = j; k < n; k++) {
            if (s[k] == 'a') {
                return false;
            }
        }
        return true;
    }
};