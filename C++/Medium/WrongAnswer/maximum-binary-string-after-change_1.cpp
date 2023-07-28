class Solution {
public:
    string maximumBinaryString(string binary) {
        
        int n = binary.size();
        int i = 0;
        while (i < n && binary[i] == '1') {
            i++;
        }
        int j = i;
        while (j < n && binary[j] == '0') {
            j++;
        }
        int k = j;
        while (k < n && binary[k] == '1') {
            k++;
        }
        int cnt = k - j;
        binary[i] = '1';
        for (int i = 0; i < cnt; i++) {
            binary[j + i] = '1';
        }
        return binary;
    }
};