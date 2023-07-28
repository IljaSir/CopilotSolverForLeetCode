class Solution {
public:
    string toHex(int num) {
        
        if (num == 0) return "0";
        string ans = "";
        int count = 0;
        while (num && count++ < 8) {
            int tmp = num & 0xf;
            if (tmp < 10) ans = char(tmp + '0') + ans;
            else ans = char(tmp - 10 + 'a') + ans;
            num >>= 4;
        }
        return ans;
    }
};