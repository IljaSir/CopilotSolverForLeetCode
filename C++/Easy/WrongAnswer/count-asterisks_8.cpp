class Solution {
public:
    int countAsterisks(string s) {
        
        int i = 0, count = 0;
        for (int j = 0; j < s.length(); j++) {
            if (s[j] == '*') {
                count++;
            }
            if (s[j] == '|') {
                if (i % 2 == 1) {
                    count--;
                }
                i++;
            }
        }
        return count;
    }
};