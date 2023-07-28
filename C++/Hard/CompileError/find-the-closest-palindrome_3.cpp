class Solution {
public:
    string nearestPalindromic(string n) {
        
        int len = n.size();
        if (len == 1) {
            return to_string((n[0] - '0') - 1);
        }
        int mid = len / 2;
        string left = n.substr(0, mid);
        string right = n.substr(mid, len - mid);
        reverse(right.begin(), right.end());
        string res = left + right;
        if (res == n) {
            // find the closest palindrome
            int i = mid - 1;
            while (i >= 0 && n[i] == '0') {
                n[i] = '9';
                i--;
            }
            if (i >= 0) {
                n[i] = n[i] - 1;
            }
            if (n[0] == '0') {
                n = n.substr(1, len - 1);
                len = len - 1;
                mid = len / 2;
                left = n.substr(0, mid);
                right = n.substr(mid, len - mid);
                reverse(right.begin(), right.end());
                res = left + right;
                return res;
            }
            left = n.substr(0, mid);
            right = n.substr(mid, len - mid);
            reverse(right.begin(), right.end());
            res = left + right;
            return res;
        }
        if (len % 2 == 0) {
            int i = mid - 1;
            // find the closest palindrome
            while (i >= 0 && n[i] == '0') {
                n[i] = '9';
                i--;
            }
            if (i >= 0) {
                n[i] = n[i] - 1;
            }
            if (n[0] == '0') {
                n = n.substr(1, len - 1);
                len = len - 1;
                mid = len / 2;
                left = n.substr(0, mid);
                right = n.substr(mid, len - mid);
                reverse(right.begin(), right.end());
                res = left + right;
                return res;
            }
            left = n.substr(0, mid);
            right = n.substr(mid, len - mid);
            reverse(right.begin(), right.end());
            res = left + right;
            return res;
        } else {
            int i = mid;
            //
    }
};