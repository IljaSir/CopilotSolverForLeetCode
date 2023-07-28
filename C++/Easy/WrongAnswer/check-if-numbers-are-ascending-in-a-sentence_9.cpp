class Solution {
public:
    bool areNumbersAscending(string s) {
        
        int last_num = 0, num = 0;
        bool found_num = false;
        for (auto c: s) {
            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
                found_num = true;
            } else {
                if (found_num) {
                    if (num <= last_num) return false;
                    last_num = num;
                    num = 0;
                    found_num = false;
                }
            }
        }
        return true;
    }
};