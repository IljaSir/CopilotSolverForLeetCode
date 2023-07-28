class Solution {
public:
    int maximumValue(vector<string>& strs) {
        
        int max = 0;
        for (auto &s : strs) {
            int num = 0;
            bool isDigit = true;
            for (auto &c : s) {
                if (isdigit(c)) {
                    num *= 10;
                    num += c - '0';
                } else {
                    isDigit = false;
                    break;
                }
            }
            if (isDigit) {
                if (num > max) {
                    max = num;
                }
            } else {
                if (s.length() > max) {
                    max = s.length();
                }
            }
        }
        return max;
    }
};