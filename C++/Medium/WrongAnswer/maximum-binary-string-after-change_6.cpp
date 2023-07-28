class Solution {
public:
    string maximumBinaryString(string binary) {
        
        int n = binary.size();
        int i = 0;
        int j = n - 1;
        while (i < n && binary[i] == '1') i++;
        while (j >= 0 && binary[j] == '0') j--;
        if (i > j) return binary;
        string res = binary.substr(0, i);
        res += string(j - i, '1');
        res += string(n - j, '0');
        return res;
    }
};