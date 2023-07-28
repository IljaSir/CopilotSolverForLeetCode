class Solution {
public:
    bool areNumbersAscending(string s) {
        
        int num = 0;
        int last = -1;
        
        for (auto c : s) {
            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
            } else {
                if (last >= num) return false;
                last = num;
                num = 0;
            }
        }
        
        return last < num;
    }
};