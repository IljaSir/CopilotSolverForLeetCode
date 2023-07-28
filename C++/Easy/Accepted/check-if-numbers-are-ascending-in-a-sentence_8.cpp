class Solution {
public:
    bool areNumbersAscending(string s) {
        
        int n = s.length();
        int i = 0;
        int last = -1;
        while (i < n) {
            int j = i;
            while (j < n && isdigit(s[j])) {
                j++;
            }
            if (j > i) {
                int v = stoi(s.substr(i, j - i));
                if (v <= last) {
                    return false;
                }
                last = v;
                i = j;
            } else {
                i++;
            }
        }
        return true;
    }
};