class Solution {
public:
    string toHex(int num) {
        
        if (num == 0) return "0";
        string ans;
        int i = 0;
        while (num && i < 8) {
            int t = num & 15;
            if (t < 10) ans.push_back(t + '0');
            else ans.push_back(t - 10 + 'a');
            num >>= 4;
            ++i;
        }
        reverse(ans.begin(), ans.end());
        return ans;
    }
};