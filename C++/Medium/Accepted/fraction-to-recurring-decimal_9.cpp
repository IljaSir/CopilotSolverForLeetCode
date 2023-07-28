class Solution {
public:
    string fractionToDecimal(int numerator, int denominator) {
        
        string s = "";
        if (numerator == 0) {
            return "0";
        }
        if (numerator < 0 ^ denominator < 0) {
            s += "-";
        }
        long long n = abs((long long)numerator);
        long long d = abs((long long)denominator);
        s += to_string(n / d);
        if (n % d == 0) {
            return s;
        }
        s += ".";
        unordered_map<long long, int> m;
        for (long long r = n % d; r; r %= d) {
            if (m.count(r)) {
                s.insert(m[r], 1, '(');
                s += ")";
                break;
            }
            m[r] = s.size();
            r *= 10;
            s += to_string(r / d);
        }
        return s;
    }
};