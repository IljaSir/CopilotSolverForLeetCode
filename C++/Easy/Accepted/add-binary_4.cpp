class Solution {
public:
    string addBinary(string a, string b) {
        
        int i = a.size() - 1;
        int j = b.size() - 1;
        int carry = 0;
        string res = "";
        while (i >= 0 || j >= 0 || carry == 1) {
            carry += (i >= 0) ? a[i] - '0' : 0;
            carry += (j >= 0) ? b[j] - '0' : 0;
            res = char(carry % 2 + '0') + res;
            carry /= 2;
            i--;
            j--;
        }
        return res;
    }
};