class Solution {
public:
    bool queryString(string s, int n) {
        
        int i = 0;
        int j = s.size() - 1;
        while (i < j) {
            swap(s[i], s[j]);
            i++;
            j--;
        }
        int m = 0;
        for (int i = 0; i < s.size(); i++) {
            if (s[i] == '1') {
                m |= (1 << i);
            }
        }
        for (int i = 1; i <= n; i++) {
            if ((m & i) == 0) {
                return false;
            }
        }
        return true;
    }
};