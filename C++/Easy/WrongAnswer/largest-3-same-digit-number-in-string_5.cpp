class Solution {
public:
    string largestGoodInteger(string num) {
        
        int n = num.size();
        int count[10] = {0};
        for (int i = 0; i < n; i++) {
            count[num[i] - '0']++;
        }
        string res;
        for (int i = 9; i >= 0; i--) {
            if (count[i] >= 3) {
                res += string(count[i] / 3, '0' + i);
            }
        }
        return res;
    }
};