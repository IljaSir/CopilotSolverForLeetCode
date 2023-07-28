class Solution {
public:
    string largestGoodInteger(string num) {
        
        int n = num.size();
        int a[10] = {0};
        for (int i = 0; i < n; ++i) {
            a[num[i] - '0']++;
        }
        int max = 0;
        for (int i = 1; i <= 9; ++i) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        if (max < 3) {
            return "";
        }
        string ret;
        for (int i = 9; i >= 0; --i) {
            if (a[i] == max) {
                for (int j = 0; j < max; ++j) {
                    ret.push_back('0' + i);
                }
                break;
            }
        }
        return ret;
    }
};