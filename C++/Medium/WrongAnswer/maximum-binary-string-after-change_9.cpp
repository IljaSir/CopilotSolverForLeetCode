class Solution {
public:
    string maximumBinaryString(string binary) {
        
        int n = binary.size();
        int cnt = 0;
        for (char c : binary) {
            if (c == '1') cnt++;
        }
        if (cnt == n) return binary;
        int i = 0;
        while (i < n && binary[i] == '1') i++;
        int j = i;
        while (j < n && binary[j] == '0') j++;
        string res = binary.substr(0, i);
        res += "1";
        res += string(j - i - 1, '1');
        res += string(n - j, '0');
        return res;
    }
};