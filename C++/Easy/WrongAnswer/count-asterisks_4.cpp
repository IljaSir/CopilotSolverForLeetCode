class Solution {
public:
    int countAsterisks(string s) {
        
        int count = 0;
        bool isAsterisk = false;
        for (int i = 0; i < s.size(); i++) {
            if (s[i] == '*') {
                isAsterisk = true;
            } else if (s[i] == '|') {
                if (isAsterisk) {
                    count++;
                    isAsterisk = false;
                }
            }
        }
        return count;
    }
};