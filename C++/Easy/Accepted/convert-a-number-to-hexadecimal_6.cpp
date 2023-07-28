class Solution {
public:
    string toHex(int num) {
        
        if (num == 0) return "0";
        string result = "";
        int base = 1;
        for (int i = 0; i < 8; i++) {
            int digit = num & 0xf;
            if (digit < 10) result = to_string(digit) + result;
            else result = char('a' + digit - 10) + result;
            num >>= 4;
        }
        while (result[0] == '0') result = result.substr(1);
        return result;
    }
};