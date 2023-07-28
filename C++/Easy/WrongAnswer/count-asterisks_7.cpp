class Solution {
public:
    int countAsterisks(string s) {
        
        int n = s.size();
        int count = 0;
        for (int i = 0; i < n; ++i) {
            if (s[i] == '|') {
                ++i;
            } else {
                ++count;
            }
        }
        return count;
    }
};