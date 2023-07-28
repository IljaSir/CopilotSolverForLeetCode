class Solution {
public:
    string fractionToDecimal(int numerator, int denominator) {
        
        if (numerator == 0) return "0";
        string ans;
        // If either one is negative (not both)
        if (numerator < 0 ^ denominator < 0) ans += '-';
        long n = labs(numerator), d = labs(denominator), r = n % d;
        ans += to_string(n / d);
        if (r == 0) return ans;
        ans += '.';
        unordered_map<int, int> m;
        while (r) {
            if (m.count(r) > 0) {
                ans.insert(m[r], 1, '(');
                ans += ')';
                break;
            }
            m[r] = ans.size();
            r *= 10;
            ans += to_string(r / d);
            r %= d;
        }
        return ans;
    }
};