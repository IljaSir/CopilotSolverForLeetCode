class Solution {
public:
    int minMaxDifference(int num) {
        
        string str = to_string(num);
        int n = str.size();
        int minVal = 0, maxVal = 0;
        for (int i = 0; i < n; i++) {
            if (str[i] != '9') {
                minVal = minVal * 10 + str[i] - '0';
            } else {
                minVal = minVal * 10 + 9;
            }
        }
        for (int i = 0; i < n; i++) {
            if (str[i] != '1' && str[i] != '0') {
                maxVal = maxVal * 10 + str[i] - '0';
            } else {
                maxVal = maxVal * 10 + 1;
            }
        }
        return maxVal - minVal;
    }
};