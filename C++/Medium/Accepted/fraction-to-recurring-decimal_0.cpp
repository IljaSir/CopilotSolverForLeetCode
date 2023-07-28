class Solution {
public:
    string fractionToDecimal(int numerator, int denominator) {
        
        if (numerator == 0) {
            return "0";
        }
        string ans;
        if (numerator < 0 ^ denominator < 0) {
            ans += '-';
        }
        long long num = labs(numerator), den = labs(denominator);
        ans += to_string(num / den);
        num %= den;
        if (num == 0) {
            return ans;
        }
        ans += '.';
        unordered_map<long long, int> m;
        for (long long r = num; r; r %= den) {
            if (m.count(r)) {
                ans.insert(m[r], 1, '(');
                ans += ')';
                break;
            }
            m[r] = ans.size();
            r *= 10;
            ans += to_string(r / den);
        }
        return ans;
    }
};