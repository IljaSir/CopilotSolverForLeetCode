class Solution {
public:
    int countAsterisks(string s) {
        
        int count = 0;
        bool flag = false;
        for (int i = 0; i < s.size(); i++) {
            if (s[i] == '*') {
                if (flag) {
                    flag = false;
                } else {
                    count++;
                    flag = true;
                }
            } else if (s[i] == '|') {
                flag = false;
            }
        }
        return count;
    }
};