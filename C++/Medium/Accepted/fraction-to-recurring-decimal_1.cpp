class Solution {
public:
    string fractionToDecimal(int numerator, int denominator) {
        
        if (numerator == 0) return "0";
        string res;
        if (numerator < 0 ^ denominator < 0) res += '-';
        long long num = labs(numerator), den = labs(denominator);
        res += to_string(num / den);
        if (num % den == 0) return res;
        res += '.';
        unordered_map<int, int> m;
        for (long long r = num % den; r; r %= den) {
            if (m.count(r) > 0) {
                res.insert(m[r], 1, '(');
                res += ')';
                break;
            }
            m[r] = res.size();
            r *= 10;
            res += to_string(r / den);
        }
        return res;
    }
};