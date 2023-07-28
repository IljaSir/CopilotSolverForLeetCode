class Solution {
public:
    string toHex(int num) {
        
        if (num == 0) return "0";
        string ans;
        unsigned int n = num;
        while (n) {
            int r = n % 16;
            if (r < 10) ans += (r + '0');
            else ans += (r - 10 + 'a');
            n /= 16;
        }
        reverse(ans.begin(), ans.end());
        return ans;
    }
};