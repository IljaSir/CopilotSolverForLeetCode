class Solution {
public:
    string toHex(int num) {
        
        if(num == 0) return "0";
        string result;
        for(int i = 0; i < 8; i++){
            int n = num & 0xf;
            if(n < 10) result = (char)(n + '0') + result;
            else result = (char)(n - 10 + 'a') + result;
            num >>= 4;
        }
        while(result[0] == '0') result.erase(0, 1);
        return result;
    }
};