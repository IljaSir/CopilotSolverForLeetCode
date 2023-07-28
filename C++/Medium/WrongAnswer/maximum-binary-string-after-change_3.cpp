class Solution {
public:
    string maximumBinaryString(string binary) {
        
        int n = binary.size();
        int count = 0;
        int i = 0;
        while (i < n && binary[i] == '1') {
            i++;
        }
        while (i < n) {
            if (binary[i] == '0') {
                count++;
            }
            i++;
        }
        string res = "";
        for (int j = 0; j < i - count - 1; j++) {
            res += "1";
        }
        res += "0";
        for (int j = 0; j < count; j++) {
            res += "1";
        }
        return res;
    }
};