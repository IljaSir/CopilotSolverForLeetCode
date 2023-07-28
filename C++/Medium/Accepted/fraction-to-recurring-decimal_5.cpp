class Solution {
public:
    string fractionToDecimal(int numerator, int denominator) {
        
        if (denominator == 0) return "NaN";
        if (numerator == 0) return "0";
        string result;
        if (numerator < 0 ^ denominator < 0) result += "-";
        long long num = abs((long long)numerator);
        long long den = abs((long long)denominator);
        result += to_string(num / den);
        long long rem = num % den;
        if (rem == 0) return result;
        result += '.';
        unordered_map<long long, int> m;
        while (rem) {
            if (m.count(rem)) {
                result.insert(m[rem], 1, '(');
                result += ')';
                break;
            }
            m[rem] = result.size();
            rem *= 10;
            result += to_string(rem / den);
            rem = rem % den;
        }
        return result;
    }
};