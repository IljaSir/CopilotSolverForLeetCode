class Solution {
public:
    string maximumBinaryString(string binary) {
        
        int n = binary.length();
        int i = 0;
        while (i < n) {
            if (binary[i] == '0') {
                break;
            }
            i++;
        }
        int j = i + 1;
        while (j < n) {
            if (binary[j] == '0') {
                i++;
            }
            j++;
        }
        for (int k = 0; k < n; k++) {
            if (k < i) {
                binary[k] = '1';
            } else {
                binary[k] = '0';
            }
        }
        return binary;
    }
};