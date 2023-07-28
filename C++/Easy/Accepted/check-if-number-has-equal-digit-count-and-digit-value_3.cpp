class Solution {
public:
    bool digitCount(string num) {
        
        int n = num.size();
        int count[10] = {0};
        for (int i = 0; i < n; ++i) {
            count[num[i] - '0']++;
        }
        for (int i = 0; i < n; ++i) {
            if (count[i] != num[i] - '0') {
                return false;
            }
        }
        return true;
    }
    bool digitValue(string num) {
        int n = num.size();
        int count[10] = {0};
        for (int i = 0; i < n; ++i) {
            count[num[i] - '0']++;
        }
        for (int i = 0; i < 10; ++i) {
            if (count[i] != i) {
                return false;
            }
        }
        return true;
    }
};