class Solution {
public:
    string maximumBinaryString(string binary) {
        
        int n = binary.length();
        int one = 0;
        int zero = 0;
        for (int i = 0; i < n; i++) {
            if (binary[i] == '0') {
                zero++;
            } else {
                one++;
            }
        }
        string res;
        res += '1';
        for (int i = 0; i < zero - 1; i++) {
            res += '1';
        }
        for (int i = 0; i < one; i++) {
            res += '0';
        }
        return res;
    }
};