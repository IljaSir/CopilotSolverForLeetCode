class Solution {
public:
    int countAsterisks(string s) {
        
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s[i] == '|') {
                i++;
                while (s[i] != '|') {
                    if (s[i] == '*') {
                        count++;
                    }
                    i++;
                }
            }
        }
        return count;
    }
};