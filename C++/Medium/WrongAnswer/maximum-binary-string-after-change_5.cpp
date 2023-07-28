class Solution {
public:
    string maximumBinaryString(string binary) {
        
        int n = binary.size();
        int i = 0;
        while (i < n && binary[i] == '1') {
            ++i;
        }
        
        int j = n - 1;
        while (j >= 0 && binary[j] == '1') {
            --j;
        }
        
        int count = 0;
        for (int k = i; k <= j; ++k) {
            if (binary[k] == '0') {
                ++count;
            }
        }
        
        string res;
        for (int k = 0; k < i; ++k) {
            res += '1';
        }
        
        if (i <= j) {
            res += '1';
            --count;
        }
        
        for (int k = 0; k < count; ++k) {
            res += '0';
        }
        
        for (int k = j + 1; k < n; ++k) {
            res += '1';
        }
        
        return res;
    }
};