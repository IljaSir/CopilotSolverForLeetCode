class Solution {
public:
    string largestGoodInteger(string num) {
        
        int freq[10] = {0};
        for (int i = 0; i < num.size(); i++) {
            freq[num[i] - '0']++;
        }
        int digit = -1;
        for (int i = 9; i >= 0; i--) {
            if (freq[i] >= 3) {
                digit = i;
                break;
            }
        }
        if (digit == -1) {
            return "";
        }
        string ans = "";
        for (int i = 0; i < 3; i++) {
            ans += (char)(digit + '0');
        }
        return ans;
    }
};