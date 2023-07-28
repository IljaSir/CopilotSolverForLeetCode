class Solution {
public:
    string addBinary(string a, string b) {
        
        int n = a.size();
        int m = b.size();
        int i = n - 1;
        int j = m - 1;
        string ans;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int x = 0;
            int y = 0;
            if (i >= 0) {
                x = a[i] - '0';
            }
            if (j >= 0) {
                y = b[j] - '0';
            }
            int sum = x + y + carry;
            ans.push_back(sum % 2 + '0');
            carry = sum / 2;
            --i;
            --j;
        }
        if (carry) {
            ans.push_back('1');
        }
        reverse(ans.begin(), ans.end());
        return ans;
    }
};