class Solution {
public:
    string fractionToDecimal(int numerator, int denominator) {
        
        long long num = numerator;
        long long den = denominator;
        string ans = "";
        if (num * den < 0) ans += '-';
        num = abs(num);
        den = abs(den);
        ans += to_string(num / den);
        num %= den;
        if (num == 0) return ans;
        ans += '.';
        unordered_map<int, int> m;
        while (num) {
            if (m.count(num)) {
                ans.insert(m[num], "(");
                ans += ')';
                break;
            }
            m[num] = ans.size();
            num *= 10;
            ans += to_string(num / den);
            num %= den;
        }
        return ans;
    }
};