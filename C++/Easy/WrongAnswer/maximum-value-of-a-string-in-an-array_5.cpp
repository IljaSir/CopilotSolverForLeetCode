class Solution {
public:
    int maximumValue(vector<string>& strs) {
        
        int max = 0;
        for (string s : strs) {
            int value = 0;
            for (char c : s) {
                if (isdigit(c)) {
                    value = value * 10 + (c - '0');
                } else {
                    value++;
                }
            }
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
};