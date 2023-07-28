class Solution {
public:
    string toHex(int num) {
        
        string ans;
        if (num == 0) return "0";
        int count = 0;
        while (num && count++ < 8) {
            int a = num & 0xf;
            if (a < 10) ans += '0' + a;
            else ans += 'a' + (a - 10);
            num >>= 4;
        }
        reverse(ans.begin(), ans.end());
        return ans;
    }
};