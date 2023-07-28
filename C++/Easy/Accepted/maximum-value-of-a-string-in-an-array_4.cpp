class Solution {
public:
    int maximumValue(vector<string>& strs) {
        
        int max = 0;
        for (auto str : strs) {
            int value = 0;
            for (auto c : str) {
                if (c >= '0' && c <= '9') {
                    value = value * 10 + (c - '0');
                } else {
                    value = str.length();
                    break;
                }
            }
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
};