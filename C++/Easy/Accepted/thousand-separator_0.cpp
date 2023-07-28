class Solution {
public:
    string thousandSeparator(int n) {
        
        if (n == 0) return "0";
        string res = "";
        int count = 0;
        while (n > 0) {
            if (count != 0 && count % 3 == 0) {
                res += ".";
            }
            res += to_string(n % 10);
            n /= 10;
            ++count;
        }
        reverse(res.begin(), res.end());
        return res;
    }
};