class Solution {
public:
    string fractionToDecimal(int numerator, int denominator) {
        
        string result;
        long long n = numerator;
        long long d = denominator;
        if (n == 0) return "0";
        if (n < 0 && d > 0 || n > 0 && d < 0) {
            result += '-';
        }
        n = abs(n);
        d = abs(d);
        result += to_string(n / d);
        if (n % d == 0) return result;
        result += '.';
        unordered_map<int, int> m;
        for (long long r = n % d; r; r %= d) {
            if (m.count(r) > 0) {
                result.insert(m[r], 1, '(');
                result += ')';
                break;
            }
            m[r] = result.size();
            r *= 10;
            result += to_string(r / d);
        }
        return result;
    }
};