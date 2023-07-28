class Solution {
public:
    bool areNumbersAscending(string s) {
        
        int num = 0;
        int last = 0;
        bool isNum = false;
        for (int i = 0; i < s.length(); i++) {
            if (s[i] >= '0' && s[i] <= '9') {
                isNum = true;
                num = num * 10 + s[i] - '0';
            } else {
                if (isNum) {
                    if (num <= last) {
                        return false;
                    }
                    last = num;
                    num = 0;
                    isNum = false;
                }
            }
        }
        return true;
    }
};