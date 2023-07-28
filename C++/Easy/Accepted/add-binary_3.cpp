class Solution {
public:
    string addBinary(string a, string b) {
        
        int n = a.size(), m = b.size();
        if (n < m) return addBinary(b, a);
        reverse(a.begin(), a.end());
        reverse(b.begin(), b.end());
        int carry = 0;
        for (int i = 0; i < n; ++i) {
            carry += a[i] - '0';
            if (i < m) carry += b[i] - '0';
            a[i] = carry % 2 + '0';
            carry /= 2;
        }
        if (carry) {
            a += (carry + '0');
        }
        reverse(a.begin(), a.end());
        return a;
    }
};