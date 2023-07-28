class Solution {
public:
    int minMaxDifference(int num) {
        
        string s = to_string(num);
        int n = s.size();
        int maxNum = 0;
        int minNum = 0;
        for (int i = 0; i < n; ++i) {
            int digit = s[i] - '0';
            if (digit != 9) {
                for (int j = i; j < n; ++j) {
                    if (s[j] == digit + '0') {
                        s[j] = '9';
                    }
                }
                maxNum = stoi(s);
                break;
            }
        }
        for (int i = 0; i < n; ++i) {
            int digit = s[i] - '0';
            if (digit != 0) {
                for (int j = i; j < n; ++j) {
                    if (s[j] == digit + '0') {
                        s[j] = '0';
                    }
                }
                minNum = stoi(s);
                break;
            }
        }
        return maxNum - minNum;
    }
};