class Solution {
public:
    string nearestPalindromic(string n) {
        
        int len = n.length();
        string ans;
        if (len == 1) {
            ans = to_string(stoi(n)-1);
            return ans;
        }
        if (len == 2) {
            if (n == "11") return "9";
            if (n == "99") return "101";
            if (n == "10") return "9";
            if (n == "90") return "99";
            if (n[0] == n[1]) return to_string(stoi(n)-1);
            if (n[0] < n[1]) return to_string(stoi(n)-1);
            if (n[0] > n[1]) return to_string(stoi(n)+1);
        }
        int mid = len/2;
        string left = n.substr(0, mid);
        string right = n.substr(mid, len-mid);
        string left2 = left;
        string right2 = right;
        reverse(right2.begin(), right2.end());
        string left3 = left;
        string right3 = right;
        reverse(right3.begin(), right3.end());
        if (right2 == right) {
            if (left == "1") {
                ans = "9";
                return ans;
            }
            if (left == "9") {
                ans = "101";
                return ans;
            }
            if (left == "10") {
                ans = "99";
                return ans;
            }
            if (left == "90") {
                ans = "909";
                return ans;
            }
            if (left == "99") {
                ans = "1001";
                return ans;
            }
            if (left[0] == '1') {
                left3 = to_string(stoi(left)-1);
                right3 = left3;
                reverse(right3.begin(), right3.end());
                ans = left3 + right3;
                return ans;
            }
            if (left[0] == '9') {
                left3 = to_string(stoi(left)+1);
                right3 = left3;
                reverse(right3.begin(), right3.end());
                ans = left3 + right3;
                return ans;
            }
            if (left[0] == '0') {
                left3 = to_string(stoi(left)+1);
                right3 = left3;
                reverse(right
    }
};