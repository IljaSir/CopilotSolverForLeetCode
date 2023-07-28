class Solution {
public:
    string baseNeg2(int n) {
        
        if (n == 0) return "0";
        string ans;
        while (n) {
            ans += '0' + (n & 1);
            n = -(n >> 1);
        }
        reverse(ans.begin(), ans.end());
        return ans;
    }
};