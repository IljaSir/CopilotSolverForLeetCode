class Solution {
public:
    bool areNumbersAscending(string s) {
        
        int last = -1;
        string num;
        for (int i=0; i<s.size(); i++) {
            if (s[i] >= '0' && s[i] <= '9') {
                num += s[i];
            } else if (num.size() > 0) {
                int cur = stoi(num);
                if (cur <= last) {
                    return false;
                }
                last = cur;
                num = "";
            }
        }
        if (num.size() > 0) {
            int cur = stoi(num);
            if (cur <= last) {
                return false;
            }
        }
        return true;
    }
};