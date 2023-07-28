class Solution {
public:
    int maximumValue(vector<string>& strs) {
        
        int max = 0;
        for (auto s : strs) {
            int value = 0;
            bool isDigit = true;
            for (auto c : s) {
                if (isdigit(c)) {
                    value = value * 10 + c - '0';
                } else {
                    isDigit = false;
                    value++;
                }
            }
            if (isDigit) {
                if (value > max) {
                    max = value;
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