class Solution {
public:
    string baseNeg2(int n) {
        
        if (n == 0) {
            return "0";
        }
        string result;
        while (n) {
            result += to_string(n & 1);
            n = -(n >> 1);
        }
        reverse(result.begin(), result.end());
        return result;
    }
};